package server.validators.request.teacher;

import server.DTO.request.teacher.AddTeacherRequest;
import server.validators.primitive.NameValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddTeacherValidator implements RequestValidator<AddTeacherRequest> {
    int maxLen;
    private final NameValidator nameValidator;

    public AddTeacherValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddTeacherRequest request) {
        List<String> errors = new ArrayList<>();

        nameValidator.isNotEmpty(request.getFirstName(), errors, "firstName");
        nameValidator.isNotEmpty(request.getLastName(), errors, "lastName");
        nameValidator.isNotEmpty(request.getMiddleName(), errors, "middleName");

        nameValidator.isNotLong(request.getFirstName(), errors, "firstname", maxLen);
        nameValidator.isNotLong(request.getLastName(), errors, "lastName", maxLen);
        nameValidator.isNotLong(request.getMiddleName(), errors, "middleName", maxLen);

        return errors;
    }
}
