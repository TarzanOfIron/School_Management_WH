package org.example.sequenser;

public class CourseSequencer {

    private static int courseId;

    public static int getCourseId() {
        return courseId;
    }

    public static int nextId() {
        return courseId++;
    }
}
