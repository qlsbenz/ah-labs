package server.validator;

import server.request.AddStudentRequest;

import java.util.ArrayList;
import java.util.List;

public class AddStudentRequestValidator
        implements RequestValidator<AddStudentRequest> {

    private final IdValidator idValidator;
    private final StringValidator stringValidator;

    public AddStudentRequestValidator() {
        this.idValidator = new IdValidator();
        this.stringValidator = new StringValidator(100);
    }

    @Override
    public List<String> validate(AddStudentRequest request) {
        List<String> errors = new ArrayList<>();

        if (request == null) {
            errors.add("Request cannot be null");
            return errors;
        }

        errors.addAll(
                stringValidator.validate(
                        request.getLastName(),
                        "lastName"
                )
        );

        errors.addAll(
                stringValidator.validate(
                        request.getFirstName(),
                        "firstName"
                )
        );

        errors.addAll(
                stringValidator.validate(
                        request.getMiddleName(),
                        "middleName"
                )
        );

        errors.addAll(
                idValidator.validate(
                        request.getGroupId()
                )
        );

        return errors;
    }
}
