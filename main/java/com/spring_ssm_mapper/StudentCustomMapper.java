package com.spring_ssm_mapper;

import com.spring_ssm_po.StudentCustom;
import com.spring_ssm_po.StudentVo;

import java.util.List;

public interface StudentCustomMapper {
    public List<StudentCustom> selectStudent(StudentVo vo);
}
