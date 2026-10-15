package server.validators.request.attendance;


import server.DTO.request.attendance.EditAttendanceRequest;
import server.validators.primitive.StatusAttendanceValidator;
import server.validators.primitive.IdValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditAttendanceValidator implements RequestValidator<EditAttendanceRequest> {
    private final int maxLen = 100;
    private final StatusAttendanceValidator statusAttendanceValidator;
    private final IdValidator idValidator;

    public EditAttendanceValidator(StatusAttendanceValidator statusAttendanceValidator, IdValidator idValidator) {
        this.statusAttendanceValidator = statusAttendanceValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(EditAttendanceRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.isId(request.getLessonId(), errors, "Lesson id");
        idValidator.isId(request.getStudentId(), errors, "Student id");

        statusAttendanceValidator.isValidStatus(request.getStatus(), errors, "status");

        return errors;
    }
}
