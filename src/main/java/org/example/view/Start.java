package org.example.view;

import org.example.data_accesse.CourseDAOSet;
import org.example.data_accesse.StudentDAOSet;
import org.example.model.Course;
import org.example.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.model.CLILogic.enwokeActionAfterGivenMainMenuOption;
import static org.example.model.CLILogic.findStudentByGivenOption;

public class Start {



    public static void start() {
        while (true) {
            printMainMenu();
            enwokeActionAfterGivenMainMenuOption(new Scanner(System.in).nextInt());
        }
    }
    

    public static void printFindCourseMenu() {
        System.out.println("1 Find Course By Name");
        System.out.println("2 Find Course By Start Date");
        System.out.println("3 Find Course By Start Id");
        System.out.println("4 Find All Courses");
    }

    private static void printMainMenu() {
        System.out.println("==============================");
        System.out.println("1 Create Student");
        System.out.println("2 Create Course");
        System.out.println("3 Register Student To Course");
        System.out.println("4 Remove Student From Course");
        System.out.println("5 Find Students");
        System.out.println("6 Find Courses");
        System.out.println("7 Exit Program");
    }

    public static void printFindStudentMenu() {
        System.out.println("1 Find Student By Name");
        System.out.println("2 Find Student By Email");
        System.out.println("3 Find Stident By Id");
        System.out.println("4 Find All Students");
    }
}
