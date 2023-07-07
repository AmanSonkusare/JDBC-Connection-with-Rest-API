package com.demo.dao;

import com.demo.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface Studentdao {
    public List<Student> studentData() throws SQLException;
    public Student getStudent(int id);
    public void updatestu(Student stu);
    public void deletestu(int id);
    public void addStudent(Student stu);

}
