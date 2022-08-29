package com.xyc.jpademo.service;

import com.xyc.jpademo.entity.User;
import com.xyc.jpademo.param.StudentParam;

import java.util.List;

public interface StudentService {

    /**
     * 通过条件查询学生
     * @param  studentParam 查询条件参数对象
     */
    List<User> findStudent(StudentParam studentParam);
}
