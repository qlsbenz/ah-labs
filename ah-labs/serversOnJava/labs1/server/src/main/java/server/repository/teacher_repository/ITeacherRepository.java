package server.repository.teacher_repository;

import server.entity.TeacherEntity;

import java.util.List;

public interface ITeacherRepository {
    TeacherEntity addTeacher(TeacherEntity teacher);
    TeacherEntity getById(long id);

    List<String> getAll();

    void update(TeacherEntity entity);
    void deleteById(long id);
}
