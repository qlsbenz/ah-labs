package server.repository.student_repository;

import server.entity.StudentEntity;

import java.util.List;

public interface IStudentRepository {
    long addStudent(StudentEntity student);
    StudentEntity getById(long id);

    List<StudentEntity> getAll();
    List<StudentEntity> getByGroupId(long groupId);
    List<StudentEntity> getByStatus(String status);

    void update(StudentEntity student);
    void deleteById(long id);
}
