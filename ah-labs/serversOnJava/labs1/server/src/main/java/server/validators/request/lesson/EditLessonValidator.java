package server.validators.request.lesson;

import server.DTO.request.lesson.EditLessonRequest;
import server.validators.primitive.DateValidator;
import server.validators.primitive.IdValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditLessonValidator implements RequestValidator<EditLessonRequest> {
    private final IdValidator idValidator;
    private final DateValidator dateValidator;

    public EditLessonValidator(IdValidator idValidator, DateValidator dateValidator) {
        this.idValidator = idValidator;
        this.dateValidator = dateValidator;
    }

    @Override
    public List<String> validate(EditLessonRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.isId(request.getId(),  errors, "Lesson id");
        idValidator.isId(request.getSubjectId(), errors, "Subject id");
        idValidator.isId(request.getGroupId(), errors, "Group id");
        idValidator.isId(request.getTeacherId(), errors, "Teacher id");

        dateValidator.isDate(request.getDate(), errors, "date");

        return errors;
    }
}
