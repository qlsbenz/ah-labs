package server.entity;

import java.util.Objects;

public class LessonEntity {
    private final Long id;
    private final long subjectId;
    private final long teacherId;
    private final long groupId;
    private final String date;
    private final int lessonNumber;
    private final long createdAt;
    private final long updatedAt;

    public LessonEntity(Long id, long subjectId, long teacherId, long groupId, String date, int lessonNumber, long createdAt, long updatedAt) {
        this.id = id;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.date = date;
        this.lessonNumber = lessonNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public long getGroupId() {
        return groupId;
    }

    public long getDate() {
        return date;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LessonEntity that = (LessonEntity) o;
        return id == that.id && subjectId == that.subjectId && teacherId == that.teacherId && groupId == that.groupId && date == that.date && lessonNumber == that.lessonNumber && createdAt == that.createdAt && updatedAt == that.updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectId, teacherId, groupId, date, lessonNumber, createdAt, updatedAt);
    }
}
