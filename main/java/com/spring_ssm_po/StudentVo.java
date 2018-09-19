package com.spring_ssm_po;

import java.util.List;

public class StudentVo {
    private Student student;
    private StudentCustom studentCustom;
    private Integer[] student_id;

    public List<StudentCustom> getList() {
        return list;
    }

    public void setList(List<StudentCustom> list) {
        this.list = list;
    }

    private List<StudentCustom> list;
    public Integer[] getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer[] student_id) {
        this.student_id = student_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentCustom getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(StudentCustom studentCustom) {
        this.studentCustom = studentCustom;
    }
}
