package com.xyc.jpademo.config;

import com.xyc.jpademo.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Configuration
public class UserAuditor implements AuditorAware<String> {

    /**
     * 获取当前创建或修改的用户
     *
     * @return 获取当前创建或修改的用户Uid
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        // request声明
        HttpServletRequest request;
        // 工号
        String username = "anonymous";
        // 拿到Session
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes !=null){
            request = requestAttributes.getRequest();
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("jpaUser");
            if (obj instanceof User){
                User user = (User) obj;
                username = user.getUsername();
            }
        }
        return Optional.of(username);
    }

}
