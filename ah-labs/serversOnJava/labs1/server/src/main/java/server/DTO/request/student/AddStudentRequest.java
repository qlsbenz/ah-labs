package server.DTO.request.student;

import server.entity.GroupEntity;
import server.model.StudentStatus;

public class AddStudentRequest {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String status;
    private final long groupId;

    public AddStudentRequest(String lastName, String firstName, String middleName, String status, long groupId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.groupId = groupId;
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

    public String getStatus() {
        return status;
    }

    public long getGroupId() {
        return groupId;
    }
}
