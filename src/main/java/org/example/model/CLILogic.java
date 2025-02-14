package org.example.model;


import org.example.data_accesse.CourseDAOSet;
import org.example.data_accesse.PersonDAOSet;
import org.example.data_accesse.StudentDAOSet;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.view.Start.printFindCourseMenu;
import static org.example.view.Start.printFindStudentMenu;

public class CLILogic {

    //static StudentDAOSet studentDAOSet = new StudentDAOSet();
    static CourseDAOSet courseDAOSet = new CourseDAOSet();
    static PersonDAOSet personDAOSet = new PersonDAOSet();


    // Menu Selector
    public static void enwokeActionAfterGivenMainMenuOption(int option) {
        switch (option) {
            case 1 -> createStudent();
            case 2 -> createCourse();
            case 3 -> registerStudentToCourse();
            case 4 -> removeStudentFromCourse();
            case 5 -> findStudent();
            case 6 -> findCourse();
            case 7 -> System.exit(1);
            default -> System.out.println("Not An Option, Try Again!");
        }
    }


    // Create Student
    private static void createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Role: ");
        String stringRole = scanner.nextLine();
        Role role = Role.valueOf(stringRole);
        personDAOSet.savePerson(new Person(name, email, address,role));
    }


    // Create Course
    private static void createCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Start Date in the following format: yyyy-mm-dd: ");
        LocalDate localDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Duration in weeks: ");
        int weeks = scanner.nextInt();
        courseDAOSet.saveCourse(new Course(name, localDate,weeks));
    }


    // Register Student
    private static void registerStudentToCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id Of The Student: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Id Of The Course: ");
        int courseId = scanner.nextInt();
        courseDAOSet.finfById(courseId).register(personDAOSet.findById(studentId));
    }


    // Unregister Student
    private static void removeStudentFromCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id Of The Student: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Id Of The Course: ");
        int courseId = scanner.nextInt();
        courseDAOSet.finfById(courseId).unregister(personDAOSet.findById(studentId));
    }


    // Find Student
    private static void findStudent() {
        printFindStudentMenu();
        findStudentByGivenOption(new Scanner(System.in).nextInt());
    }

    public static void findStudentByGivenOption(int menuOption) {
        switch (menuOption) {
            case 1 -> findStudentByName();
            case 2 -> findStudentByEmail();
            case 3 -> findStudentByID();
            case 4 -> System.out.println(personDAOSet.findAll());
            default -> System.out.println("Not An Option, Try Again!");
        }
    }

    private static void findStudentByName() {
        System.out.print("Enter Students Name: ");
        System.out.println(personDAOSet.findByName(new Scanner(System.in).nextLine()));
    }

    private static void findStudentByEmail() {
        System.out.print("Enter Students Email: ");
        System.out.println(personDAOSet.findByEmail(new Scanner(System.in).nextLine()));
    }

    private static void findStudentByID() {
        System.out.print("Enter Students Id:");
        System.out.println(personDAOSet.findById(new Scanner(System.in).nextInt()));
    }


    // Find Course
    private static void findCourse() {
        printFindCourseMenu();
        findCourseByGivenOption(new Scanner(System.in).nextInt());

    }

    private static void findCourseByGivenOption(int option) {
        switch (option) {
            case 1 -> findCourseByName();
            case 2 -> findCourseByStartDate();
            case 3 -> findCourseByCourseId();
            case 4 -> System.out.println(courseDAOSet.findAll());
            default -> System.out.println("Not An Option, Try Again!");
        }
    }

    private static void findCourseByName() {
        System.out.print("Enter Course Name: ");
        System.out.println(courseDAOSet.findByName(new Scanner(System.in).nextLine()));
    }

    private static void findCourseByStartDate() {
        System.out.print("Enter Start Date in the following format: yyyy-mm-dd: ");
        System.out.println(courseDAOSet.findByDate(LocalDate.parse(new Scanner(System.in).nextLine())));
    }

    private static void findCourseByCourseId() {
        System.out.println("Enter Course Id");
        System.out.println(courseDAOSet.finfById(new Scanner(System.in).nextInt()));
    }

}
