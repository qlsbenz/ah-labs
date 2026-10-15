package server.DTO.response.student;

import server.DTO.response.group.GroupResponse;
import server.model.StudentStatus;

public class StudentResponse {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String middlename;
    private final StudentStatus status;
    private final GroupResponse group;

    public StudentResponse(long id, String lastName, String firstName, String middlename, StudentStatus status, GroupResponse group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middlename = middlename;
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

    public String getMiddlename() {
        return middlename;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public GroupResponse getGroup() {
        return group;
    }
}
