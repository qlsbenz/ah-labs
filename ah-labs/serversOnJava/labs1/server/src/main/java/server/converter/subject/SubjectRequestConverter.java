package server.converter.subject;

import server.DTO.request.subject.AddSubjectRequest;
import server.DTO.request.subject.EditSubjectRequest;
import server.entity.SubjectEntity;

import java.time.Instant;

public class SubjectRequestConverter {
    public SubjectEntity toEntity(AddSubjectRequest request) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new SubjectEntity(
                null,
                request.getName(),
                milliseconds,
                milliseconds
        );
    }

    public SubjectEntity toEntity(EditSubjectRequest request, long createdAt) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new SubjectEntity(
                request.getId(),
                request.getName(),
                createdAt,
                milliseconds
        );
    }
}
