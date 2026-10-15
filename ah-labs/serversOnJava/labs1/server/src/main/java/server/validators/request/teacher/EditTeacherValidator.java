package server.validators.request.teacher;

import server.DTO.request.teacher.EditTeacherRequest;
import server.validators.primitive.NameValidator;
import server.validators.primitive.IdValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

    public class EditTeacherValidator implements RequestValidator<EditTeacherRequest> {
    private final int maxLen = 100;
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public EditTeacherValidator(NameValidator nameValidator, IdValidator idValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(EditTeacherRequest request) {
        List<String> errors = new ArrayList<>();

        nameValidator.isNotEmpty(request.getFirstName(), errors, "firstName");
        nameValidator.isNotEmpty(request.getLastName(), errors, "lastName");
        nameValidator.isNotEmpty(request.getMiddleName(), errors, "middleName");

        nameValidator.isNotLong(request.getFirstName(), errors, "firstname", maxLen);
        nameValidator.isNotLong(request.getLastName(), errors, "lastName", maxLen);
        nameValidator.isNotLong(request.getMiddleName(), errors, "middleName", maxLen);

        idValidator.isId(request.getId(), errors, "id");

        return errors;
    }
}
