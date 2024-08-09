package com.student_project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentUtility {
    private List<Student> students;

    StudentUtility() {
        students = new ArrayList<>();
    }

    public void addStudent(int id, String name, int age, String courseName) {
        Student student = new Student(id, name, age, courseName);
        students.add(student);
        System.out.println("Student added successfully\n" + student);
        System.out.println();
    }

    public void deleteStudent(int id) {
        boolean found = false;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId() == id) {
                iterator.remove();
                System.out.println("Student deleted successfully");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found!");
        }
        System.out.println();
    }

    public void searchStudent(int id) {
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentId() == id) {
                System.out.println(student);
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not Found");
        }
    }

    public void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(name.trim())) {
                System.out.println("Student found: " + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found");
        }
    }

    public void getAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Found");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentId() == id) {
                student.setStudentName(name);
                student.setStudentAge(age);
                student.setStudentCourse(course);
                found = true;
                System.out.println("Student updated successfully: " + student);
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found!");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StudentUtility s1 = new StudentUtility();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("Enter your choice: ");
                System.out.println("1. Add Student");
                System.out.println("2. Delete Student");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Search Student by Name");
                System.out.println("5. Return All Students");
                System.out.println("6. Update Student");
                System.out.println("7. Exit");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        try {
                            System.out.println("Enter Student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter Student Name: ");
                            String name = sc.nextLine().trim();
                            System.out.println("Enter Student Age: ");
                            int age = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter Student Course: ");
                            String course = sc.nextLine().trim();
                            s1.addStudent(id, name, age, course);
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                            sc.nextLine(); // Clear the buffer
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("Enter Student ID to delete: ");
                            int deleteId = sc.nextInt();
                            s1.deleteStudent(deleteId);
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                            sc.nextLine(); // Clear the buffer
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Enter Student ID: ");
                            int searchID = sc.nextInt();
                            s1.searchStudent(searchID);
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                            sc.nextLine(); // Clear the buffer
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Enter Student Name: ");
                            String nameToSearch = sc.nextLine().trim();
                            s1.searchStudentByName(nameToSearch);
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                        }
                        break;
                    case 5:
                        s1.getAllStudents();
                        break;
                    case 6:
                        try {
                            System.out.println("Enter Student ID to Update:");
                            int updateId = sc.nextInt();
                            sc.nextLine();
                            boolean studentExists = false;
                            for (Student student : s1.students) {
                                if (student.getStudentId() == updateId) {
                                    studentExists = true;
                                    break;
                                }
                            }

                            if (studentExists) {
                                System.out.println("New Student Name: ");
                                String newName = sc.nextLine().trim();
                                System.out.println("New Age: ");
                                int newAge = sc.nextInt();
                                sc.nextLine();
                                System.out.println("New Course: ");
                                String newCourse = sc.nextLine().trim();
                                s1.updateStudent(updateId, newName, newAge, newCourse);
                            } else {
                                System.out.println("Student Not Found!");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                            sc.nextLine(); // Clear the buffer
                        }
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
