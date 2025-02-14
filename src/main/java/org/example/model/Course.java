package org.example.model;

import org.example.sequenser.CourseSequencer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Person supervisor;
    private HashSet<Person> personStudents = new HashSet<>();
    private HashSet<Student> students = new HashSet<>();
    private HashSet<Lecture> lectures = new HashSet<>();


    // Constructor

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        setCourseName(courseName);
        setStartDate(startDate);
        setWeekDuration(weekDuration);
        setId();
    }


    // Setters
    private void setId() {
        this.id = CourseSequencer.nextId();
    }

    public void setCourseName(String courseName) {
        Objects.requireNonNull(courseName);
        if (courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty courseName");
        }
        this.courseName = courseName;
    }

    public void setStartDate(LocalDate startDate) {
        Objects.requireNonNull(startDate);
        this.startDate = startDate;
    }

    public void setWeekDuration(int weekDuration) {
        if (weekDuration <= 0 ){
            throw new IllegalArgumentException("Invalid numberOfWeeks");
        }
        this.weekDuration = weekDuration;
    }

    public void setSupervisor(Person supervisor) {
        Objects.requireNonNull(supervisor);
        if (supervisor.getRole().equals(Role.Student)){
            System.out.println("Not a teacher!");
            return;
        }
        this.supervisor = supervisor;
    }



    // Getters


    public Person getSupervisor() {
        return supervisor;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public HashSet<Person> getPersonStudents() {
        return personStudents;
    }

    public HashSet<Lecture> getLectures() {
        return lectures;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    // Methods
    public void register(Person student) {
       Objects.requireNonNull(student);
       if (student.getRole().equals(Role.Teacher)){
           System.out.println("Not a student");
           return;
       }
        if (personStudents.contains(student)) {
            System.out.println("Student already registered");
            return;
        }
        personStudents.add(student);
    }

    public void register(Student student) {
        Objects.requireNonNull(student);
        if (students.contains(student)) {
            System.out.println("Student already registered");
            return;
        }
        students.add(student);
    }


    public void unregister(Student student) {
        Objects.requireNonNull(student);
        if (!students.contains(student)){
            System.out.println("No such student registered in the course");
            return;
        }
        students.remove(student);
    }

    public void unregister(Person student) {
        Objects.requireNonNull(student);
        if (!personStudents.contains(student)){
            System.out.println("No such student registered in the course");
            return;
        }
        personStudents.remove(student);
    }

    public void addLecture(Lecture lecture) {
        Objects.requireNonNull(lectures);
        if (lectures.contains(lecture)){
            System.out.println("Lecture already added");
            return;
        }
        lectures.add(lecture);

    }

    public void removeLecture(Lecture lecture) {
        Objects.requireNonNull(lectures);
        if (!lectures.contains(lecture)){
            System.out.println("Lecture is not added to this course");
            return;
        }
        lectures.remove(lecture);

    }


}
