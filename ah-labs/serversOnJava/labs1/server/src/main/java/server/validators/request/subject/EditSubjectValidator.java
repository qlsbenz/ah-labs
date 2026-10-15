package server.validators.request.subject;

import server.DTO.request.subject.EditSubjectRequest;
import server.validators.primitive.NameValidator;
import server.validators.primitive.IdValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditSubjectValidator implements RequestValidator<EditSubjectRequest> {
    private final int maxLen = 100;
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public EditSubjectValidator(NameValidator nameValidator, IdValidator idValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(EditSubjectRequest request) {
        List<String> errors = new ArrayList<>();

        nameValidator.isNotEmpty(request.getName(), errors, "name");
        nameValidator.isNotLong(request.getName(), errors, "name", maxLen);
        idValidator.isId(request.getId(),  errors, "id");

        return errors;
    }
}
