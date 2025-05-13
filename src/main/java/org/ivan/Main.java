package org.ivan;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/highschool";
    private static final String USER = "root";
    private static final String PASSWORD = "Sandia4you";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (var con = getConnection()) {
            System.out.println("Intrduzca código postal");
            int zipcode = sc.nextInt();
            sc.nextLine();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE zipcode= ?");
            ps.setInt(1, zipcode);
            ResultSet rs = ps.executeQuery();
            boolean encontrado = false;
            while (rs.next()) {
                encontrado = true;
                String nif = rs.getString("nif");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int zipcode1 = rs.getInt("zipcode");
                System.out.println("Nombre: " + name + " " + surname + ", NIF: " + nif + ", Código postal: " + zipcode1);
            }

            if (!encontrado) {
                System.out.println("No se encontraron estudiantes con ese código postal.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
