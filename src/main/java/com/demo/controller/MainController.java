package com.demo.controller;

import com.demo.model.Student;
import com.demo.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class MainController {

    @Autowired
    StudentService stu;
    @GetMapping("/hii")
    public String std()  {
 return "hiiiiiiii";
  }

    @GetMapping("studentList")
    public List<Student> student() throws SQLException {
        return stu.studentData();

    }

    @GetMapping("studentList/{id}")
    public Student stu(@PathVariable int id) throws SQLException {
        return stu.getStudent(id);
    }

    @PostMapping("update-student/{id}")
    public void updateStu(@RequestBody Student st) {
        stu.updatestu(st);
    }

    @DeleteMapping("delete-student/{id}")
    public void deleteStu(@PathVariable int id) {
        stu.deleteStu(id);
    }

    @PostMapping("addStudent")
    public void addStudent(@RequestBody Student stud) {
        stu.addStudent(stud);
    }
}
