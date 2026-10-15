package server.converter.lesson;

import server.DTO.response.group.GroupResponse;
import server.DTO.response.lesson.LessonResponse;
import server.DTO.response.subject.SubjectResponse;
import server.DTO.response.teacher.TeacherResponse;
import server.entity.GroupEntity;
import server.entity.LessonEntity;
import server.entity.SubjectEntity;
import server.entity.TeacherEntity;

public class LessonEntityConverter {
    public LessonResponse toResponse(LessonEntity lesson, TeacherEntity teacher, GroupEntity group, SubjectEntity subject) {
        return new LessonResponse(
                lesson.getId(),
                new SubjectResponse(subject.getId(), subject.getName()),
                new TeacherResponse(teacher.getId(), teacher.getLastName(), teacher.getFirstName(), teacher.getLastName()),
                new GroupResponse(group.getId(), group.getName()),
                lesson.getDate(),
                lesson.getLessonNumber()
        );
    }
}
