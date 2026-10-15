package server.date_base;

import server.entity.*;

import javax.swing.*;
import java.util.Map;

public class DataBase {
    private final Map<Long, StudentEntity> student;
    private final Map<Long, GroupEntity> group;
    private final Map<Long, TeacherEntity> teacher;
    private final Map<Long, SubjectEntity> subject;
    private final Map<Long, LessonEntity> lesson;
    private final Map<Long, AttendanceEntity> attendance;

    private long finalStudentId;
    private long finalGroupId;
    private long finalTeacherId;
    private long finalSubjectId;
    private long finalLessonId;
    private long finalAttendanceId;

    public DataBase(Map<Long, StudentEntity> student, Map<Long, GroupEntity> group, Map<Long, TeacherEntity> teacher, Map<Long, SubjectEntity> subject, Map<Long, LessonEntity> lesson, Map<Long, AttendanceEntity> attendance, long finalStudentId, long finalGroupId, long finalTeacherId, long finalSubjectId, long finalLessonId, long finalAttendanceId) {
        this.student = student;
        this.group = group;
        this.teacher = teacher;
        this.subject = subject;
        this.lesson = lesson;
        this.attendance = attendance;
        this.finalStudentId = finalStudentId;
        this.finalGroupId = finalGroupId;
        this.finalTeacherId = finalTeacherId;
        this.finalSubjectId = finalSubjectId;
        this.finalLessonId = finalLessonId;
        this.finalAttendanceId = finalAttendanceId;
    }

    public Map<Long, StudentEntity> getStudent() {
        return student;
    }

    public Map<Long, GroupEntity> getGroup() { return group; }

    public Map<Long, TeacherEntity> getTeacher() {
        return teacher;
    }

    public Map<Long, SubjectEntity> getSubject() {
        return subject;
    }

    public Map<Long, LessonEntity> getLesson() {
        return lesson;
    }

    public Map<Long, AttendanceEntity> getAttendance() {
        return attendance;
    }

    public long getFinalStudentId() {
        return finalStudentId;
    }

    public long getFinalGroupId() {
        return finalGroupId;
    }

    public long getFinalTeacherId() {
        return finalTeacherId;
    }

    public long getFinalSubjectId() {
        return finalSubjectId;
    }

    public long getFinalLessonId() {
        return finalLessonId;
    }

    public long getFinalAttendanceId() {
        return finalAttendanceId;
    }

    public long nextStudentId() { return ++finalStudentId; }

    public long nextGroupId() {
        return ++finalGroupId;
    }

    public long nextTeacherId() {
        return ++finalTeacherId;
    }

    public long nextSubjectId() {
        return ++finalSubjectId;
    }

    public long nextLessonId() {
        return ++finalLessonId;
    }

    public long nextAttendanceId() {
        return ++finalAttendanceId;
    }
}
