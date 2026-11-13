 package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static class Student {
        String id;
        String name;
        String course;

        Student(String id, String name, String course) {
            this.id = id;
            this.name = name;
            this.course = course;
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent();
                    break;

                case "2":
                    displayStudents();
                    break;

                case "3":
                    searchStudent();
                    break;

                case "4":
                    updateStudent();
                    break;

                case "5":
                    deleteStudent();
                    break;

                case "6":
                    System.out.println("Thank you for using Student Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static Student findStudent(String id) {
        for (Student s : students) {
            if (s.id.equals(id)) {
                return s;
            }
        }
        return null;
    }

    static void addStudent() {

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine().trim();

        if (id.isEmpty() || findStudent(id) != null) {
            System.out.println("Invalid or duplicate Student ID!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Course: ");
        String course = sc.nextLine().trim();

        if (name.isEmpty() || course.isEmpty()) {
            System.out.println("Name and course cannot be empty!");
            return;
        }

        students.add(new Student(id, name, course));
        System.out.println("Student added successfully!");
    }

    static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n----- STUDENT DETAILS -----");

        for (Student s : students) {
            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
            System.out.println("Course: " + s.course);
            System.out.println("---------------------------");
        }
    }

    static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine().trim();

        Student s = findStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Student Found!");
            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
            System.out.println("Course: " + s.course);
        }
    }

    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine().trim();

        Student s = findStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine().trim();

        if (name.isEmpty() || course.isEmpty()) {
            System.out.println("Fields cannot be empty!");
            return;
        }

        s.name = name;
        s.course = course;

        System.out.println("Student updated successfully!");
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine().trim();

        Student s = findStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
        } else {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        }
    }
}
