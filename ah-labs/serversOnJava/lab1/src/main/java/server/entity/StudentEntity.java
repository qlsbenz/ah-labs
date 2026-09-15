package server.entity;

import java.util.Objects;
import server.entity.StudentStatus;

public class StudentEntity {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private long groupId;
    private long createdAt;
    private long updatedAt;
    private StudentStatus status;

    public StudentEntity(long id, String lastName, String firstName, String middleName, long groupId, long createdAt, long updatedAt, StudentStatus status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public long getGroupId() {
        return groupId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public StudentStatus status() { return status; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id && groupId == that.groupId && createdAt == that.createdAt && updatedAt == that.updatedAt && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, groupId, createdAt, updatedAt);
    }
}
