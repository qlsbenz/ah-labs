package server.converter.attendance;

import jdk.jshell.Snippet;
import server.DTO.request.attendance.AddAttendanceRequest;
import server.DTO.request.attendance.EditAttendanceRequest;
import server.entity.AttendanceEntity;
import server.model.AttendanceStatus;


import java.time.Instant;

public class AttendanceRequestConverter {
    public AttendanceEntity toEntity(AddAttendanceRequest request) {
        Instant now = Instant.now();
        long time = now.toEpochMilli();

        return new AttendanceEntity(
                null,
                request.getLessonId(),
                request.getStudentId(),
                AttendanceStatus.valueOf(request.getStatus().trim().toUpperCase()),
                time,
                time
        );
    }

    public AttendanceEntity toEntity(EditAttendanceRequest request, long createdAt) {
        Instant now = Instant.now();
        long time = now.toEpochMilli();

        return new AttendanceEntity(
                request.getId(),
                request.getLessonId(),
                request.getStudentId(),
                AttendanceStatus.valueOf(request.getStatus().trim().toUpperCase()),
                createdAt,
                time
        );
    }
}
