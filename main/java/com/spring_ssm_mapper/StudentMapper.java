package com.spring_ssm_mapper;

import com.spring_ssm_po.Student;
import com.spring_ssm_po.StudentCustom;
import com.spring_ssm_po.StudentVo;

public interface StudentMapper {
    //通过id查询商品信息
    public Student getIdStudent(Integer id);

    //通过id修改商品信息

    public void updateIdStudentCustom(StudentCustom studentCustom);

    //通过id批量删除商品信息
    public void deleteIdStudent(Integer[] id);
}
