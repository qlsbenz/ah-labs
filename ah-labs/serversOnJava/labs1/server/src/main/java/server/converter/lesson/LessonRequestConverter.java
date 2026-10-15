package server.converter.lesson;

import server.DTO.request.lesson.AddLessonRequest;
import server.DTO.request.lesson.EditLessonRequest;
import server.entity.LessonEntity;

import java.time.Instant;

public class LessonRequestConverter {
    public LessonEntity toEntity(AddLessonRequest request) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new LessonEntity(
                null,
                request.getSubjectId(),
                request.getTeacherId(),
                request.getGroupId(),
                request.getDate(),
                request.getLessonNumber(),
                milliseconds,
                milliseconds
        );
    }

    public LessonEntity toEntity(EditLessonRequest request, long createdAt) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new LessonEntity(
                request.getId(),
                request.getSubjectId(),
                request.getTeacherId(),
                request.getGroupId(),
                request.getDate(),
                request.getLessonNumber(),
                createdAt,
                milliseconds
        );
    }
}
