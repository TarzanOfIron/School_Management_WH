package org.example.sequenser;

public class StudentSequencer {

    private static int studentId;

    public static int getStudentId() {
        return studentId;
    }

    public static int nextId() {
        return studentId++;
    }
}
