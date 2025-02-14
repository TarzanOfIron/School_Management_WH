package org.example.sequenser;

public class LectureSequencer {

    private static int lectureId;

    public static int getLectureId() {
        return lectureId;
    }

    public static int nextId() {
        return lectureId++;
    }
}
