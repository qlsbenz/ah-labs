package server.repository.subject_repository;

import server.entity.SubjectEntity;

import java.util.List;

public interface ISubjectRepository {
    SubjectEntity addSubject(SubjectEntity subject);
    SubjectEntity getById(long id);
    List<SubjectEntity> getAll();
    SubjectEntity getByName(String name);
    void update(SubjectEntity subject);
    void deleteById(long id);
}
