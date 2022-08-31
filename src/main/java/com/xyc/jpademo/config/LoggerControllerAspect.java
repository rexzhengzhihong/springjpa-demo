package com.xyc.jpademo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * aop类  拦截
 * 1、拦截请求信息 用logger打印出来，方便跟踪
 *
 * @author onzzzheng
 * @create 2017-10-18 16:27
 */
@Aspect   //定义一个切面
@Component
public class LoggerControllerAspect {
    private static final Logger logger = LoggerFactory.getLogger(com.xyc.jpademo.config.LoggerControllerAspect.class);
    public LoggerControllerAspect(){
        //logger.info("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }
    // 定义切点Pointcut
    //@Pointcut("execution(public * com.netwit.bizbank.web.Controller.*Controller.*(..))")
    //    @Pointcut("execution(public * com.netwit.bizbank..*Controller.*(..))")
    //@jjw 这里路径配错了导致学生端无法显示路由
    @Pointcut("execution(public * com.xyc.jpademo..*Controller.*(..))")
    public void excudeService() {
    }


    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime=System.currentTimeMillis();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        String uri = "";
        if(sra!=null){
            HttpServletRequest request = sra.getRequest();
            String url = request.getRequestURL().toString();
            String method = request.getMethod();
             uri = request.getRequestURI();
            String queryString = request.getQueryString();
            logger.info("请求开始： url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
        }
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        if(null==result){
            //logger.info("请求结束，返回值可能在servletUtil");
        }else{
            String resultValue=result.toString();
            String resultType="Object";
            if (result instanceof Integer) {
                resultType="Integer";
            } else if (result instanceof String) {
                resultType="String";
            } else if (result instanceof Double) {
                resultType="Double";
            } else if (result instanceof Float) {
                resultType="Float";
            } else if (result instanceof Long) {
                resultType="Long";
            } else if (result instanceof Boolean) {
                resultType="Boolean";
            } else if (result instanceof Date) {
                resultType="Date";
            }else if (result instanceof ModelAndView) {
                resultType="ModelAndView";
            }else{
                logger.info("请求结束，controller的返回值没有匹配，请检查！");
            }
            String useTime=";  路由请求耗时：" + (System.currentTimeMillis() - startTime) + " ms ";
            logger.info("请求结束，controller的返回值是{}:" + resultValue+useTime,resultType);
        }

        return result;
    }
}
