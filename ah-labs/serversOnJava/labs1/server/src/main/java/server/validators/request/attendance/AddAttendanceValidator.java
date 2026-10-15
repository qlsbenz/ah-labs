package server.validators.request.attendance;

import server.DTO.request.attendance.AddAttendanceRequest;
import server.validators.primitive.IdValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddAttendanceValidator implements RequestValidator<AddAttendanceRequest> {
    private final IdValidator idValidator;

    public AddAttendanceValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(AddAttendanceRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.isId(request.getLessonId(), errors, "Lesson id");
        idValidator.isId(request.getStudentId(), errors, "Student id");

        return errors;
    }
}
