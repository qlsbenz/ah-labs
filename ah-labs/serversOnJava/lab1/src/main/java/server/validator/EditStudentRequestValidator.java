package server.validator;

import server.request.EditStudentRequest;

import java.util.ArrayList;
import java.util.List;

public class EditStudentRequestValidator
        implements RequestValidator<EditStudentRequest> {

    private final IdValidator idValidator;
    private final StringValidator stringValidator;

    public EditStudentRequestValidator() {
        this.idValidator = new IdValidator();
        this.stringValidator = new StringValidator(100);
    }

    @Override
    public List<String> validate(EditStudentRequest request) {
        List<String> errors = new ArrayList<>();

        if (request == null) {
            errors.add("Request cannot be null");
            return errors;
        }

        errors.addAll(idValidator.validate(request.getId()));

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

        if (request.getStatus() == null) {
            errors.add("status cannot be null");
        }

        return errors;
    }
}