package server.validator;

import server.request.EditStudentGroupRequest;

import java.util.ArrayList;
import java.util.List;

public class EditStudentGroupRequestValidator
        implements RequestValidator<EditStudentGroupRequest> {

    private final IdValidator idValidator;
    private final StringValidator stringValidator;

    public EditStudentGroupRequestValidator() {
        this.idValidator = new IdValidator();
        this.stringValidator = new StringValidator(100);
    }

    @Override
    public List<String> validate(EditStudentGroupRequest request) {
        List<String> errors = new ArrayList<>();

        if (request == null) {
            errors.add("Request cannot be null");
            return errors;
        }

        errors.addAll(idValidator.validate((request.getId())));
        errors.addAll(stringValidator.validate(request.getName(), "name"));

        return errors;
    }
}
