package com.hcl.onlineexam.dao;

import com.hcl.onlineexam.dto.Student;
import com.hcl.onlineexam.services.DataBaseServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public Student login(String email, String password) {

        Student s = new Student();
        try {

            Connection con = DataBaseServices.getConnection();

            PreparedStatement ps = con.prepareStatement("select * from Student where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String e = rs.getString(1);
                String m = rs.getString(2);
                String p = rs.getString(3);
                String n = rs.getString(4);
                String c = rs.getString(5);

                s.setEmail(e);
                s.setMobile(m);
                s.setPassword(p);
                s.setName(n);
                s.setCollege(c);

            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return s;
    }

    public String signup(Student s) {

        String result = "";

        try {
            Connection con = DataBaseServices.getConnection();

            PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?)");

            ps.setString(1, s.getEmail());
            ps.setString(2, s.getMobile());
            ps.setString(3, s.getPassword());
            ps.setString(4, s.getName());
            ps.setString(5, s.getCollege());

            int x = ps.executeUpdate();

            if (x == 1) {
                result = "done";
            }

        } catch (Exception e) {
            result = e.toString();
        }

        return result;
    }

    public Student getStudentByEmail(String email) {

        return null;
    }

    public static List<Student> getAllStudents() {

        List<Student> slist = new ArrayList<Student>();

        try {

            Connection con = DataBaseServices.getConnection();

            PreparedStatement ps = con.prepareStatement("select * from student");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String email = rs.getString(1);
                String mobile = rs.getString(2);
                String password = rs.getString(3);
                String name = rs.getString(4);
                String college = rs.getString(5);
                
                Student s = new Student(email, mobile, name, password, college);
                
                slist.add(s);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return slist;
    }

}
