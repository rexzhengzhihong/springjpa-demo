package com.xyc.jpademo.controller;

import com.xyc.jpademo.entity.User;
import com.xyc.jpademo.param.UserParam;
import com.xyc.jpademo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 新增用户
     */
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PostMapping("/getUser")
    public List<User> getUser(UserParam userParam) {
        return userService.findUser(userParam);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

    /**
     * 修改用户
     */
    @PutMapping("")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 全查用户
     */
    @GetMapping("")
    public List<User> findAll() {
        return userService.findAllUser();
    }

    /**
     * id查用户
     */
    @GetMapping("/{id}")
    public User findbyId(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    /**
     * 登录
     * @param session 拿到session
     * @param user 前端传来的数据：有效字段只有name
     * @return 有此用户名返回ok，没有则error
     */
    @PostMapping("/login")
    public String login(HttpSession session, @RequestBody User user) {
        return userService.login(session,user);
    }

}
