package com.springboot.service.imp;

import com.springboot.mapper.StudentMapper;
import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImp implements StudentService{

    @Autowired
    public StudentMapper studentMapper;

    @Override
    public void inserStudent(Student student) {
        studentMapper.insert(student);
    }
}
