package server.validators.request.lesson;

import server.DTO.request.lesson.AddLessonRequest;
import server.validators.primitive.DateValidator;
import server.validators.primitive.IdValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddLessonValidtor implements RequestValidator<AddLessonRequest> {
    private final DateValidator dateValidator;
    private final IdValidator idValidator;

    public AddLessonValidtor(DateValidator dateValidator, IdValidator idValidator) {
        this.dateValidator = dateValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(AddLessonRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.isId(request.getSubjectId(), errors, "subject id");
        idValidator.isId(request.getGroupId(), errors, "Group id");
        idValidator.isId(request.getTeacherId(), errors, "Teacher id");

        dateValidator.isDate(request.getDate(), errors, "date");

        return errors;
    }
}
