package server.entity;

import java.util.Objects;

import server.model.StudentStatus;

public class StudentEntity {
    private final Long id;
    private final String lastName;
    private final String firstName;
    private final String middlename;
    private final StudentStatus status;
    private final long groupId;
    private final long createdAt;
    private final long updatedAt;

    public StudentEntity(Long id, String lastName, String firstName, String middlename, long groupId, long createdAt, long updatedAt, StudentStatus status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middlename = middlename;
        this.groupId = groupId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Long getId() {
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

    public long getGroupId() {
        return groupId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public StudentStatus getStatus() {
        return status;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id && groupId == that.groupId && createdAt == that.createdAt && updatedAt == that.updatedAt && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(middlename, that.middlename) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middlename, groupId, createdAt, updatedAt, status);
    }
}
