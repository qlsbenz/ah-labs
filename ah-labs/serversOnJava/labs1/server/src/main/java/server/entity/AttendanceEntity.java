package server.entity;

import server.model.AttendanceStatus;

import java.util.Objects;

public class AttendanceEntity {
    private final Long id;
    private final long lessonId;
    private final long studentId;
    private final AttendanceStatus status;
    private final long createdAt;
    private final long updateAt;

    public AttendanceEntity(Long id, long lessonId, long studentId, AttendanceStatus status, long createdAt, long updateAt) {
        this.id = id;
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public long getLessonId() {
        return lessonId;
    }

    public long getStudentId() {
        return studentId;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceEntity that = (AttendanceEntity) o;
        return lessonId == that.lessonId && studentId == that.studentId && createdAt == that.createdAt && updateAt == that.updateAt && Objects.equals(id, that.id) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lessonId, studentId, status, createdAt, updateAt);
    }
}
