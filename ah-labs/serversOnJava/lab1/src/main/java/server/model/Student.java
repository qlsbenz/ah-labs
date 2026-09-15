package server.model;

import server.entity.StudentStatus;

public class Student {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private StudentStatus status;
    private Group group;

    public Student(long id, String lastName, String firstName, String middleName, StudentStatus status, Group group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public Group getGroup() {
        return group;
    }
}