package server.validators.request.lesson;

import server.DTO.request.lesson.GetLessonsByGroupRequest;
import server.validators.primitive.DateValidator;
import server.validators.primitive.IdValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonByGroupValidator implements RequestValidator<GetLessonsByGroupRequest> {
    private final IdValidator idValidator;
    private final DateValidator dateValidator;

    public GetLessonByGroupValidator(IdValidator idValidator, DateValidator dateValidator) {
        this.idValidator = idValidator;
        this.dateValidator = dateValidator;
    }

    @Override
    public List<String> validate(GetLessonsByGroupRequest request) {
        List<String> errors = new ArrayList<>();

        dateValidator.isDate(request.getStartDate(), errors, "startDate");
        dateValidator.isDate(request.getEndDate(), errors, "endDate");
        idValidator.isId(request.getGroupId(), errors, "groupId");

        return errors;
    }
}
