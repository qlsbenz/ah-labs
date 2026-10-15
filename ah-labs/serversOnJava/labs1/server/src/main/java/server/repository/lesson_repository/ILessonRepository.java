package server.repository.lesson_repository;

import server.entity.LessonEntity;
import server.entity.SubjectEntity;

import java.util.List;

public interface ILessonRepository {
    LessonEntity addLesson(LessonEntity lesson);
    LessonEntity getById(long id);

    List<SubjectEntity> getAllByTime(String startDate, String endDate);

    void edit(LessonEntity lesson);
    void deleteById(long id);

    List<LessonEntity> getLessonByGroup(long startDate, long endDate, long groupId);
    List<LessonEntity> getLessonByTeacher(long startData, long endDate, long groupId);

}
