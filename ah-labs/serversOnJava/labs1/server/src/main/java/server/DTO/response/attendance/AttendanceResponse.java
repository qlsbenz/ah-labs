package server.DTO.response.attendance;

import server.DTO.response.lesson.LessonResponse;
import server.DTO.response.student.StudentResponse;
import server.model.AttendanceStatus;

public class AttendanceResponse {
    private final long id;
    private final LessonResponse lessonId;
    private final StudentResponse studentId;
    private final AttendanceStatus status;

    public AttendanceResponse(long id, LessonResponse lessonId, StudentResponse studentId, AttendanceStatus status) {
        this.id = id;
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public LessonResponse getLessonId() {
        return lessonId;
    }

    public StudentResponse getStudentId() {
        return studentId;
    }

    public AttendanceStatus getStatus() {
        return status;
    }
}
