package org.ivan;

import org.ivan.service.StudentService;
import org.ivan.student.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        System.out.println("Introduzca código postal:");
        int zipCode = sc.nextInt();
        sc.nextLine();
        List<Student> students = studentService.getStudentsByZipCode(zipCode);
        if (students.isEmpty()) {
            System.out.println("No se encontraron estudiantes con ese código postal.");
        } else {
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }
}

