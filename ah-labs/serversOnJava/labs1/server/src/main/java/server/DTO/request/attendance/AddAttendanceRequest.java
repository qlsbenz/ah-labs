package server.DTO.request.attendance;

import server.model.AttendanceStatus;

public class AddAttendanceRequest {
    private final long lessonId;
    private final long studentId;
    private final String status;

    public AddAttendanceRequest(long lessonId, long studentId, String status) {
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.status = status;
    }

    public long getLessonId() {
        return lessonId;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getStatus() {
        return status;
    }
}

