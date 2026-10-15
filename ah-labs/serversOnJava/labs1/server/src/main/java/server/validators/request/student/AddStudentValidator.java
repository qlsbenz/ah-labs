package server.validators.request.student;

import server.DTO.request.student.AddStudentRequest;
import server.validators.primitive.NameValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentValidator implements RequestValidator<AddStudentRequest> {
    private final int maxLen = 100;
    private final NameValidator nameValidator;

    public AddStudentValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddStudentRequest request) {
        List<String> errors = new ArrayList<>();

        nameValidator.isNotEmpty(request.getMiddleName(), errors, "middleName");
        nameValidator.isNotEmpty(request.getFirstName(), errors, "firstName");
        nameValidator.isNotEmpty(request.getLastName(), errors, "lastName");

        nameValidator.isNotLong(request.getMiddleName(), errors, "middleName", maxLen);
        nameValidator.isNotLong(request.getFirstName(), errors, "firstName", maxLen);
        nameValidator.isNotLong(request.getLastName(), errors, "lastName", maxLen);

        return errors;
    }
}