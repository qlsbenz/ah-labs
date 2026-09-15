package server.converter;

import server.entity.StudentEntity;
import server.entity.StudentStatus;
import server.model.Group;
import server.model.Student;
import server.request.AddStudentRequest;
import server.request.EditStudentRequest;
import server.response.StudentResponse;

public class StudentConverter {

    public StudentEntity fromRequest(AddStudentRequest request, long id, long createdAt, long updatedAt) {

        return new StudentEntity(id, request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getStatus(), request.getGroupId(), createdAt, updatedAt
        );
    }

    public StudentEntity fromRequest(EditStudentRequest request, StudentEntity oldEntity, long updatedAt) {

        return new StudentEntity(oldEntity.getId(), request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getStatus(), request.getGroupId(), oldEntity.getCreatedAt(), updatedAt
        );
    }

    public Student toModel(StudentEntity entity, GroupEntity groupEntity) {

        Group group = new Group(groupEntity.getId(), groupEntity.getName()
        );

        return new Student(entity.getId(), entity.getLastName(), entity.getFirstName(), entity.getMiddleName(), entity.getStatus(), group
        );
    }

    public StudentResponse toResponse(Student model) {
        return new StudentResponse(model.getId(), model.getLastName(), model.getFirstName(), model.getMiddleName(), model.getGroup().getId(), model.getStatus()
        );
    }
}