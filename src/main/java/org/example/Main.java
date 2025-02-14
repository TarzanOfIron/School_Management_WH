package org.example;

import org.example.model.Course;
import org.example.model.Lecture;
import org.example.model.Person;
import org.example.model.Role;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Start.start();

        Person student = new Person("Bob", "email", "address", Role.Student);
        Person student1 = new Person("Bob", "email", "address", Role.Student);
        Person teacher = new Person("Tbob", "Temail", "Taddress", Role.Teacher);
        Person teacher1 = new Person("Tbob", "Temail", "Taddress", Role.Teacher);
        Course course = new Course("Math", LocalDate.now().plusMonths(1),12);
        Course course1 = new Course("Math", LocalDate.now().plusMonths(1),12);
        Lecture lecture = new Lecture("Math101", LocalDate.now().plusMonths(1), teacher);
        Lecture lecture1 = new Lecture("Math101", LocalDate.now().plusMonths(1), teacher);

        course.setSupervisor(teacher);
        System.out.println(course.getSupervisor().getName());
        course.register(student);
        course.register(student1);
        System.out.println(course.getPersonStudents());
        course.addLecture(lecture);
        System.out.println(course.getLectures());
        lecture.addTeacher(teacher);


    }
}