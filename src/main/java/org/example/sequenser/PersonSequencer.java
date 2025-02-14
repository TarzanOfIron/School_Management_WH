package org.example.sequenser;

public class PersonSequencer {
    private static int personId;

    public static int getPersonId() {
        return personId;
    }

    public static int nextId() {
        return personId++;
    }
}
