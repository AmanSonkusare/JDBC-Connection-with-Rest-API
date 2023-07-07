package com.demo.service;

import com.demo.dao.Studentdao;
import com.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentImpl implements StudentService{

@Autowired
Studentdao stu;
    @Override
    public List<Student> studentData() throws SQLException {
        return stu.studentData();
    }

    @Override
    public Student getStudent(int id) {
        return stu.getStudent(id);
    }

    @Override
    public void updatestu(Student st) {
        stu.updatestu(st);
    }

    @Override
    public void deleteStu(int id) {
        stu.deletestu(id);
    }

    @Override
    public void addStudent(Student student) {
        stu.addStudent(student);
    }
}
