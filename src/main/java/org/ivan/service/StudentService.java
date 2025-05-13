package org.ivan.service;

import org.ivan.dao.ConfigPool;
import org.ivan.student.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final DataSource dataSource;

    public StudentService() {
        this.dataSource = ConfigPool.getDataSource();
    }

    public List<Student> getStudentsByZipCode(int zipCode) {
        List<Student> students = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE zipcode = ?")) {
            
            ps.setInt(1, zipCode);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nif = rs.getString("nif");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    int zipcode = rs.getInt("zipcode");
                    students.add(new Student(nif, name, surname, zipcode));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener estudiantes", e);
        }
        return students;
    }
}
