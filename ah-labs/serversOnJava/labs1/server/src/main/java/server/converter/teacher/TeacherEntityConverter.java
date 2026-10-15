package server.converter.teacher;

import server.DTO.response.teacher.TeacherResponse;
import server.entity.TeacherEntity;

public class TeacherEntityConverter {
    public TeacherResponse toResponse(TeacherEntity teacher) {
        return new TeacherResponse(
                teacher.getId(),
                teacher.getLastName(),
                teacher.getFirstName(),
                teacher.getMiddleName()
        );
    }
}
