package server.validators.request.subject;

import server.DTO.request.subject.AddSubjectRequest;
import server.validators.primitive.NameValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddSubjectValidator implements RequestValidator<AddSubjectRequest> {
    private final int maxLen = 100;
    private final NameValidator nameValidator;

    public AddSubjectValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddSubjectRequest request) {
        List<String> errors = new ArrayList<>();

        nameValidator.isNotEmpty(request.getName(), errors, "name");
        nameValidator.isNotLong(request.getName(), errors, "name", maxLen);

        return errors;
    }
}
