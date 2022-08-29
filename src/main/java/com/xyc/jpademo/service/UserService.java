package com.xyc.jpademo.service;

import com.xyc.jpademo.entity.User;
import com.xyc.jpademo.param.UserParam;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface UserService
{
    /**
     * 新增用户
     * @param user 用户对象
     */
    User insertUser(User user);

    /**
     * 删除用户
     * @param id 删除id
     */
    void deleteUser(Integer id);

    /**
     * 修改用户
     * @param user 用户信息
     */
    User updateUser(User user);

    /**
     * 查询所有用户
     */
    List<User> findAllUser();

    /**
     * 通过id查询用户
     * @param id 用户id
     */
    User findUserById(Integer id);

    /**
     * 通过条件查询用户
     * @param userParam 用户查询条件参数对象
     */
    List<User> findUser(UserParam userParam);

    /**
     * 登录
     * @param session httpSession
     * @param user 前端传来的用户对象
     *
     */
    String login(HttpSession session, User user);

}

