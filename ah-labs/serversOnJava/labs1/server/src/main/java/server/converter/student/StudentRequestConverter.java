package server.converter.student;


import server.DTO.request.student.AddStudentRequest;
import server.DTO.request.student.EditStudentRequest;
import server.entity.StudentEntity;
import server.model.StudentStatus;

import java.time.Instant;

public class StudentRequestConverter {
    public StudentEntity toEntity(AddStudentRequest request) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new StudentEntity(null,
                request.getLastName(),
                request.getFirstName(),
                request.getMiddleName(),
                request.getGroupId(),
                milliseconds,
                milliseconds,
                StudentStatus.valueOf(request.getStatus().trim().toUpperCase())
        );
    }

    public StudentEntity toEntity(EditStudentRequest request, long createdAt) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new StudentEntity(
                request.getId(),
                request.getLastName(),
                request.getFirstName(),
                request.getMiddleName(),
                request.getGroupId(),
                createdAt,
                milliseconds,
                StudentStatus.valueOf(request.getStatus().trim().toUpperCase())
        );
    }
}
