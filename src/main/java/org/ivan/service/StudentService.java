package org.ivan.service;

import org.ivan.student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final String URL = "jdbc:mysql://localhost:3306/highschool";
    private static final String USER = "root";
    private static final String PASSWORD = "Sandia4you";

    public List<Student> getStudentsByZipCode(int zipCode) {
        List<Student> students = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE zipcode = ?");
            ps.setInt(1, zipCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nif = rs.getString("nif");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int zipcode = rs.getInt("zipcode");
                students.add(new Student(nif, name, surname, zipcode));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener estudiantes", e);
        }
        return students;
    }
}
