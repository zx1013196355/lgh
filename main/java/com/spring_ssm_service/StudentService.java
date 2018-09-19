package com.spring_ssm_service;

import com.spring_ssm_po.StudentCustom;
import com.spring_ssm_po.StudentVo;

import java.util.List;

public interface StudentService {
    //查询商品信息
    public List<StudentCustom> selectStudent(StudentVo vo) throws Exception;

    //根据id查询商品信息

    public StudentCustom getIdStudent(Integer id) throws  Exception;

    public void updateIdStudentCustom(Integer id, StudentCustom studentCustom);
    //通过id批量删除商品信息
    public void deleteIdStudent(Integer[] id);

}
