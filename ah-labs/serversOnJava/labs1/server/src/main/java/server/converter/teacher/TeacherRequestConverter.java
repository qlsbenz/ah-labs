package server.converter.teacher;

import server.DTO.request.student.EditStudentRequest;
import server.DTO.request.teacher.AddTeacherRequest;
import server.DTO.request.teacher.EditTeacherRequest;
import server.entity.StudentEntity;
import server.entity.TeacherEntity;

import java.time.Instant;

public class TeacherRequestConverter {
    public TeacherEntity toEntity(AddTeacherRequest request) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new TeacherEntity(null,
                request.getLastName(),
                request.getFirstName(),
                request.getMiddleName(),
                milliseconds,
                milliseconds
        );
    }

    public TeacherEntity toEntity(EditTeacherRequest request, long createdAt) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new TeacherEntity(null,
                request.getLastName(),
                request.getFirstName(),
                request.getMiddleName(),
                createdAt,
                milliseconds
        );
    }
}
