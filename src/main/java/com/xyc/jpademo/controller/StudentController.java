package com.xyc.jpademo.controller;

import com.xyc.jpademo.entity.User;
import com.xyc.jpademo.param.UserParam;
import com.xyc.jpademo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

//    @PostMapping("/getStudent")
//    public List<User> getUser(UserParam userParam) {
//        return studentService.findStudent(userParam);
//    }


}
