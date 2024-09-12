package Tarea4;

import javax.swing.*;
import java.sql.SQLException;

public class Student {
    private String dni;
    private String name;
    private String surname;
    private int age;

    public Student(String dni, String name, String surname, int age) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    protected static Student collectStudentData() {
        try {
            String id = collectStudentId();
            if (!ManageStudents.studentExists(id)) {
                String name = JOptionPane.showInputDialog(null, "Indicate the student's name");
                String surname = JOptionPane.showInputDialog(null, "Indicate the student's surname");
                String ageStr = JOptionPane.showInputDialog(null, "Indicate the student's age");
                int age = Integer.parseInt(ageStr);
                return new Student(id, name, surname, age);
            }
        } catch (SQLException sqlexception) {
            JOptionPane.showMessageDialog(null, sqlexception);
        }

        return null;
    }

    protected static String collectStudentId() {
        String id = JOptionPane.showInputDialog(null, "Indicate student's ID");
        return id;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
