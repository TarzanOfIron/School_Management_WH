package org.example.model;

import org.example.sequenser.LectureSequencer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Lecture {

    private String lectureName;
    private int lectureId;
    private HashSet<Person> teachers = new HashSet<>();
    private HashSet<Person> students = new HashSet<>();
    private LocalDate date;

    public Lecture(String lectureName, LocalDate date, Person teacher) {
        setLectureName(lectureName);
        addTeacher(teacher);
        setDate(date);
        setLectureId();
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        Objects.requireNonNull(lectureName);
        this.lectureName = lectureName;
    }

    public HashSet<Person> getStudents() {
        return students;
    }

    public void setStudents(Person student) {
        Objects.requireNonNull(student);
        if (!student.getRole().equals(Role.Student)) {
            System.out.println("Person Is not a student.");
            return;
        }
        students.add(student);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        Objects.requireNonNull(date);
        this.date = date;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId() {
        this.lectureId = LectureSequencer.nextId();
    }

    public HashSet<Person> getTeachers() {
        return teachers;
    }

    public void addTeacher(Person teacher) {
        Objects.requireNonNull(teacher);
        if (!teacher.getRole().equals(Role.Teacher)){
            System.out.println("Person is not a teacher.");
            return;
        }
        if (teachers.contains(teacher)) {
            System.out.println("Teacher already teaching this lecture");
            return;
        }
        teachers.add(teacher);
    }

    public void removeTeacher(Person teacher) {
        Objects.requireNonNull(teacher);
        if (!teacher.getRole().equals(Role.Teacher)){
            System.out.println("Person is not a teacher.");
            return;
        }
        if (!teachers.contains(teacher)) {
            System.out.println("Teacher not added to lecture");
            return;
        }
        teachers.remove(teacher);
    }
}
