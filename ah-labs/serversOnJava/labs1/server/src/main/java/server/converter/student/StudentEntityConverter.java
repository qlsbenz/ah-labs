package server.converter.student;

import server.DTO.response.group.GroupResponse;
import server.DTO.response.student.StudentResponse;
import server.entity.GroupEntity;
import server.entity.StudentEntity;
import server.model.StudentStatus;

public class StudentEntityConverter {
    public StudentResponse toResponse(StudentEntity student, String groupName) {
        return new StudentResponse(
                student.getId(),
                student.getLastName(),
                student.getFirstName(),
                student.getMiddlename(),
                student.getStatus(),
                new GroupResponse(student.getGroupId(), groupName)
        );
    }
}
