package server.validator;

import server.request.AddStudentGroupRequest;

import java.util.ArrayList;
import java.util.List;

public class AddStudentGroupRequestValidator
        implements RequestValidator<AddStudentGroupRequest> {

    private final StringValidator stringValidator;

    public AddStudentGroupRequestValidator() {
        this.stringValidator = new StringValidator(100);
    }

    @Override
    public List<String> validate(AddStudentGroupRequest request) {
        List<String> errors = new ArrayList<>();

        if (request == null) {
            errors.add("Request cannot be null");
            return errors;
        }

        errors.addAll(
                stringValidator.validate(request.getName(), "name"));
        return errors;
    }
}