package com.xyc.jpademo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Clazz {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clazzname")
    private String clazzname;

    @Column(name = "clazzcode")
    private String clazzcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClazzname() {
        return clazzname;
    }

    public void setClazzname(String clazzname) {
        this.clazzname = clazzname;
    }

    public String getClazzcode() {
        return clazzcode;
    }

    public void setClazzcode(String clazzcode) {
        this.clazzcode = clazzcode;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", clazzname='" + clazzname + '\'' +
                ", clazzcode='" + clazzcode + '\'' +
                '}';
    }
}
