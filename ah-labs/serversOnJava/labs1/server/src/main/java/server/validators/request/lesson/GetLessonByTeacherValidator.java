package server.validators.request.lesson;

import server.DTO.request.lesson.GetLessonByTeacherRequest;
import server.validators.primitive.DateValidator;
import server.validators.primitive.IdValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonByTeacherValidator implements RequestValidator<GetLessonByTeacherRequest> {
    private final IdValidator idValidator;
    private final DateValidator dateValidator;

    public GetLessonByTeacherValidator(IdValidator idValidator, DateValidator dateValidator) {
        this.idValidator = idValidator;
        this.dateValidator = dateValidator;
    }

    @Override
    public List<String> validate(GetLessonByTeacherRequest request) {
        List<String> errors = new ArrayList<>();

        dateValidator.isDate(request.getStartDate(), errors, "startDate");
        dateValidator.isDate(request.getEndDate(), errors, "endDate");
        idValidator.isId(request.getTeacherId(), errors, "teacherId");

        return errors;
    }
}
