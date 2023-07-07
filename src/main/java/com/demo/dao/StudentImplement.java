package com.demo.dao;

import com.demo.model.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Repository
public class StudentImplement implements Studentdao{

    public Connection postgresql() {
        try {
            // postgrelsql driver
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Student", "postgres", "aman");
            System.out.println("Connection successfull");
            return c;
        } catch (Exception ex) {

        }
        return null;
    }


    @Override
    public List<Student> studentData() throws SQLException {
        System.out.println(" i am present in dao class");
        List<Student> list = new ArrayList<>();


        try {
            Connection dbConnection = postgresql();
            String sql = "Select * from student";
            Statement Statement = dbConnection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);

            while (resultSet.next()) {
                String a = resultSet.getString("name");
                System.out.println("Name = " + resultSet.getString("name"));
                // String name = resultSet.getString("name");
                String b = resultSet.getString("roll_no");
                System.out.println("Roll No. = " + resultSet.getString("roll_no"));
                // list.add(resultSet.getString("name"));
                Student s = new Student();
                s.setName(a);
                s.setRoll_no(b);
                list.add(s);

            }
        } catch (Exception exception) {

        }
        return list;
    }

    @Override
    public Student getStudent(int id) {
        Student s1 = null;
        try {
            Connection dbConnection = postgresql();
            String sql = "Select * from student where id='" + id + "'";
            Statement Statement = dbConnection.createStatement();
            ResultSet resultSet = Statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("Name = " + resultSet.getString("name"));
                System.out.println("Roll No. = " + resultSet.getString("roll_no"));
                int s = resultSet.getInt("id");
                String p = resultSet.getString("name");
                String q = resultSet.getString("roll_no");

                s1 = new Student();
                s1.setId(s);
                s1.setName(p);
                s1.setRoll_no(q);

            }
        } catch (Exception ex) {

        }
        return s1;
    }

    @Override
    public void updatestu(Student stu) {
        try {
            System.out.println(" i am inside the update quary");
            Connection dbConnection = postgresql();
            String sql = "update student set name='" + stu.getName() + "' ,roll_no='" + stu.getRoll_no() + "' where id='" + stu.getId() + "'";
            PreparedStatement pre = dbConnection.prepareStatement(sql);
            System.out.println("preparestatment=" + pre);
            int i = pre.executeUpdate();
        } catch (Exception exception) {

        }

    }

    @Override
    public void deletestu(int id) {

        try {
            Connection dbConnection = postgresql();
            String sql = "delete from student where id='" + id + "'";
            PreparedStatement pre = dbConnection.prepareStatement(sql);
            System.out.println("preparestatment=" + pre);
            int i = pre.executeUpdate();
        } catch (Exception exception) {

        }

    }

    @Override
    public void addStudent(Student stu) {
        try {
            Connection dbConnection = postgresql();
            String sql = "insert into student  values('" + stu.getId() + "','" + stu.getName() + "','" + stu.getRoll_no() + "')";
            PreparedStatement pre = dbConnection.prepareStatement(sql);
            System.out.println("data insert=" + pre);
            pre.executeUpdate();

        } catch (Exception exception) {

        }
    }
}
