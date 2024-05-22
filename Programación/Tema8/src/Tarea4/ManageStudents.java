package Tarea4;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class ManageStudents {
    private static Connection connection;

    protected static String initialize() {
        openConnection();
        String[] possibleOptions = {"Add student", "Get student", "Delete student", "Modify student", "Get students list"};
        String optionSelected = (String) JOptionPane.showInputDialog(null, "Select an option",
                "Students management", JOptionPane.QUESTION_MESSAGE, null, possibleOptions,
                possibleOptions[0]);

        return optionSelected;
    }

    private static void openConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException classnotfound) {
            System.out.println("Error loading MariaDB driver." + classnotfound);
        }

        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/school",
                        "usuarioGlobal", "abc123.");
            }

        } catch (SQLException sqlexception) {
            System.out.println("Error connecting to the database");
            sqlexception.getMessage();
        }
    }



    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException sqlexception) {
            System.out.println("Error closing the connection.");
            sqlexception.getMessage();
        }
    }

    protected static boolean addStudent(Student student) {
        openConnection();
        try {
            if (studentExists(student.getDni())) {
                JOptionPane.showMessageDialog(null, "The student already exists in the database");
                return false;
            } else {
                try {
                    PreparedStatement preparedQuery = connection.prepareStatement("INSERT INTO student(dni, name, surname, " +
                            "age) VALUES (?, ?, ?, ?);");

                    preparedQuery.setString(1, student.getDni());
                    preparedQuery.setString(2, student.getName());
                    preparedQuery.setString(3, student.getSurname());
                    preparedQuery.setInt(4, student.getAge());
                    preparedQuery.executeUpdate();
                    preparedQuery.close();
                    closeConnection();
                    JOptionPane.showMessageDialog(null, "Student added successfully.");
                    return true;
                } catch (NumberFormatException numberFormat) {
                    JOptionPane.showMessageDialog(null, "Invalid age.");
                    return false;
                }
            }
        } catch (SQLException sqlexception) {
            JOptionPane.showMessageDialog(null, "SQLException: " + sqlexception);
            return false;
        } finally {
            closeConnection();
        }
    }

    protected static Student getStudent(String dni) {
        openConnection();
        Student studentFound = null;
        try {
            PreparedStatement preparedQuery = connection.prepareStatement("SELECT * FROM student WHERE dni = ?");
            preparedQuery.setString(1, dni);
            ResultSet student = preparedQuery.executeQuery();
            if (student.next()) {
                studentFound = new Student(student.getString("dni"), student.getString("name"),
                        student.getString("surname"), student.getInt("age"));

            } else {
                JOptionPane.showMessageDialog(null, "Student not found.");
            }
        } catch (SQLException sqlexception) {
            JOptionPane.showMessageDialog(null, sqlexception);
        } finally {
            closeConnection();
        }
        JOptionPane.showMessageDialog(null, studentFound);
        return studentFound;
    }

    protected static boolean deleteStudent(String dni){
        openConnection();
        try {
            if (studentExists(dni)) {
               int confirm = JOptionPane.showConfirmDialog(null, "Student found, are you sure you want to delete it?");
               if (confirm == JOptionPane.YES_OPTION) {
                   String query = "DELETE FROM student WHERE dni = ?";
                   PreparedStatement preparedQuery = connection.prepareStatement(query);
                   preparedQuery.setString(1, dni);
                   preparedQuery.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Student delete successfully");
                   return true;
               } else {
                   JOptionPane.showMessageDialog(null, "Interrupting program.");
               }
            } else {
                JOptionPane.showMessageDialog(null, "The student doesn't exists.");
            }
        } catch (SQLException sqlexception) {
            JOptionPane.showMessageDialog(null, sqlexception);
        } finally {
            closeConnection();
        }

        return false;
    }


    protected static boolean studentExists(String id) throws SQLException{
        Statement query = connection.createStatement();
        ResultSet students = query.executeQuery("SELECT * FROM student");
        while(students.next()) {
            if (students.getString("dni").equals(id)) {
                students.close();
                query.close();
                return true;
            }
        }
        return false;
    }

    protected static boolean modifyStudent(String dni) {
        openConnection();
        try {
            if (ManageStudents.studentExists(dni)) {
                JOptionPane.showMessageDialog(null, "Student found");
                String[] options = {"Name", "Surname", "Age"};
                String optionSelected = (String) JOptionPane.showInputDialog(null,
                        "What do you want to modify?", "Students management", JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (optionSelected.equals("Name")) {
                    String name = JOptionPane.showInputDialog(null, "Indicate the new student's name");
                    String query = "UPDATE student SET name = ? WHERE dni = ?";
                    PreparedStatement preparedQuery = connection.prepareStatement(query);
                    preparedQuery.setString(1, name);
                    preparedQuery.setString(2, dni);
                    preparedQuery.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Student modified correctly");
                    return true;

                } else if (optionSelected.equals("Surname")) {
                    String surname = JOptionPane.showInputDialog(null, "Indicate the new student's surname");
                    String query = "UPDATE student SET surname = ? WHERE dni = ?";
                    PreparedStatement preparedQuery = connection.prepareStatement(query);
                    preparedQuery.setString(1, surname);
                    preparedQuery.setString(2, dni);
                    preparedQuery.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Student modified correctly");
                    return true;

                } else if (optionSelected.equals("Age")) {
                    String ageStr = JOptionPane.showInputDialog(null, "Indicate the new student's age");
                    int age = Integer.parseInt(ageStr);
                    String query = "UPDATE student SET age = ? WHERE dni = ?";
                    PreparedStatement preparedQuery = connection.prepareStatement(query);
                    preparedQuery.setInt(1, age);
                    preparedQuery.setString(2, dni);
                    preparedQuery.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Student modified correctly");
                    return true;
                }
            }

        } catch (SQLException sqlexception) {
            JOptionPane.showMessageDialog(null, sqlexception);
        } finally {
            closeConnection();
        }
        return false;
    }

    protected static ArrayList<Student> getStudentsList() {
        ArrayList<Student> studentList = new ArrayList<>();
        openConnection();
        try {
            String query = "SELECT * FROM student";
            PreparedStatement preparedQuery = connection.prepareStatement(query);
            ResultSet students = preparedQuery.executeQuery();
            while (students.next()) {
                studentList.add(new Student (students.getString("dni"), students.getString("name"),
                        students.getString("surname"), students.getInt("age")));
            }
        } catch (SQLException sqlexception) {
            JOptionPane.showMessageDialog(null, sqlexception);
        } finally {
            closeConnection();
        }

        return studentList;
    }

    protected static String printStudentsList(ArrayList<Student> studentList) {
        String studentPrint = "";
        for (Student student : studentList) {
            studentPrint += student.toString() + "\n";
        }
        return studentPrint;
    }

}
