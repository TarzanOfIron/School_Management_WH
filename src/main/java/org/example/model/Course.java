package org.example.model;

import org.example.sequenser.StudentSequencer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private HashSet<Student> students = new HashSet<>();


    // Constructor

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        setCourseName(courseName);
        setStartDate(startDate);
        setWeekDuration(weekDuration);
        setId();
    }


    // Setters
    private void setId() {
        this.id = StudentSequencer.nextId();
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


    // Getters


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

    public HashSet<Student> getStudents() {
        return students;
    }


    // Methods
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


}
