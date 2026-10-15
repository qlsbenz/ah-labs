package server.validators.request.student;

import server.DTO.request.student.EditStudentRequest;
import server.validators.primitive.IdValidator;
import server.validators.primitive.NameValidator;
import server.validators.primitive.StatusValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentValidator implements RequestValidator<EditStudentRequest> {

    private final int maxLen = 100;
    private final NameValidator nameValidator;
    private final server.validators.primitive.IdValidator idValidator;
    private final StatusValidator statusValidator;

    public EditStudentValidator(NameValidator nameValidator, IdValidator idValidator, StatusValidator statusValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
        this.statusValidator = statusValidator;
    }

    @Override
    public List<String> validate(EditStudentRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.isId(request.getGroupId(), errors, "id");
        idValidator.isId(request.getId(), errors, "id");

        nameValidator.isNotEmpty(request.getFirstName(), errors, "firstName");
        nameValidator.isNotEmpty(request.getLastName(), errors, "lastName");
        nameValidator.isNotEmpty(request.getMiddleName(), errors, "middleName");

        nameValidator.isNotLong(request.getFirstName(), errors, "firstname", maxLen);
        nameValidator.isNotLong(request.getLastName(), errors, "lastName", maxLen);
        nameValidator.isNotLong(request.getMiddleName(), errors, "middleName", maxLen);

        statusValidator.isValidStatus(request.getStatus(), errors, "status");

        return errors;
    }
}
