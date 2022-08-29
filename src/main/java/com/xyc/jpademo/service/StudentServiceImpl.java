package com.xyc.jpademo.service;

import com.xyc.jpademo.entity.User;
import com.xyc.jpademo.param.StudentParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Override
    public List<User> findStudent(StudentParam studentParam) {
        return null;
    }
}
