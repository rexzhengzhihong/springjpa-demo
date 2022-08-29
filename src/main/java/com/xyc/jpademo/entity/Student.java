package com.xyc.jpademo.entity;

import javax.persistence.*;

public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "studentname")
    private String studentname;

    @Column(name = "studentcode")
    private String studentcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clazz_id", referencedColumnName = "id")
    private Clazz clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    public Integer getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(Integer clazz_id) {
        this.clazz_id = clazz_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentname='" + studentname + '\'' +
                ", studentcode='" + studentcode + '\'' +
                ", clazz_id=" + clazz_id +
                '}';
    }
}
