package server.repository.student_repository;

import server.date_base.DataBase;
import server.entity.StudentEntity;

import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final DataBase dataBase;

    public StudentRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public long addStudent(StudentEntity student) {
        long id = dataBase.nextStudentId();
        dataBase.getStudent().put(id, student);
        return id;
    }

    @Override
    public StudentEntity getById(long id) {
        return null;
    }

    @Override
    public List<StudentEntity> getAll() {
        return List.of();
    }

    @Override
    public List<StudentEntity> getByGroupId(long groupId) {
        return List.of();
    }

    @Override
    public List<StudentEntity> getByStatus(String status) {
        return List.of();
    }

    @Override
    public void update(StudentEntity student) {

    }

    @Override
    public void deleteById(long id) {

    }
}
