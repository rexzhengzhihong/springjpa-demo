package com.xyc.jpademo.param;

public class StudentParam {

    private String studentname;
    private String studentcode;

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

    @Override
    public String toString() {
        return "StudentParam{" +
                "studentname='" + studentname + '\'' +
                ", studentcode='" + studentcode + '\'' +
                '}';
    }
}
