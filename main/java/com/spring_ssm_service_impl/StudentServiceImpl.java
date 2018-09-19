package com.spring_ssm_service_impl;

import com.spring_ssm_exception.CustomException;
import com.spring_ssm_mapper.StudentCustomMapper;
import com.spring_ssm_mapper.StudentMapper;
import com.spring_ssm_po.Student;
import com.spring_ssm_po.StudentCustom;
import com.spring_ssm_po.StudentVo;
import com.spring_ssm_service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentCustomMapper studentCustomMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentCustom> selectStudent(StudentVo vo) throws Exception {
        return studentCustomMapper.selectStudent(vo);
    }

    @Override
    public StudentCustom getIdStudent(Integer id) throws Exception {
        Student student = studentMapper.getIdStudent(id);

        if (student == null) {
            throw new CustomException("没有此学生");
        }
        StudentCustom studentCustom = null;
        if (student != null) {
            studentCustom = new StudentCustom();

            BeanUtils.copyProperties(student, studentCustom);
        }

        return studentCustom;
    }

    @Override
    public void updateIdStudentCustom(Integer id, StudentCustom studentCustom) {
        studentCustom.setId(id);
        studentMapper.updateIdStudentCustom(studentCustom);

    }

    @Override
    public void deleteIdStudent(Integer[] id) {

        studentMapper.deleteIdStudent(id);
    }
}
