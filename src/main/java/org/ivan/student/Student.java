package org.ivan.student;

import java.util.Objects;

public class Student {
    private String nif;
    private String name;
    private String surname;
    private int zipCode;

    public Student(String nif, String name, String surname, int zipCode) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return zipCode == student.zipCode && Objects.equals(nif, student.nif) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, zipCode);
    }

    @Override
    public String toString() {
        return String.format(
                "Student {nif='%s', name='%s', surname='%s', zipCode=%d}",
                nif, name, surname, zipCode
        );
    }
}
