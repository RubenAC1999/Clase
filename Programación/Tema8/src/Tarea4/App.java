package Tarea4;

import javax.swing.*;

import static Tarea4.ManageStudents.*;

public class App {
    public static void main(String[] args) {
        String option = ManageStudents.initialize();

        switch (option) {
            case "Add student":
                ManageStudents.addStudent(Student.collectStudentData());
                break;

            case "Get student":
                ManageStudents.getStudent(Student.collectStudentId());
                break;

            case "Delete student":
                ManageStudents.deleteStudent(Student.collectStudentId());
                break;

            case "Modify student":
                ManageStudents.modifyStudent(Student.collectStudentId());
                break;

            case "Get students list":
                JOptionPane.showMessageDialog(null, ManageStudents.printStudentsList(getStudentsList()));
                break;
        }
    }
}
