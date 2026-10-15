package server.validators.request.group;

import server.DTO.request.group.EditStudentGroupRequest;
import server.validators.primitive.IdValidator;
import server.validators.primitive.NameValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentGroupValidator implements RequestValidator<EditStudentGroupRequest> {
    private final int maxLen = 100;
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public EditStudentGroupValidator(NameValidator nameValidator, IdValidator idValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }


    @Override
    public List<String> validate(EditStudentGroupRequest request) {
        List<String> errors = new ArrayList<>();

        nameValidator.isNotEmpty(request.getName(), errors, "name");
        nameValidator.isNotLong(request.getName(), errors, "name", maxLen);
        idValidator.isId(request.getId(),  errors, "id");

        return errors;
    }
}
