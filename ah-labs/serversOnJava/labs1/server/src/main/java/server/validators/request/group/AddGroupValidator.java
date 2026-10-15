package server.validators.request.group;

import server.DTO.request.group.AddGroupRequest;
import server.validators.primitive.NameValidator;
import server.validators.request.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddGroupValidator implements RequestValidator<AddGroupRequest> {
    private final int maxLen = 100;
    private final NameValidator nameValidator;

    public AddGroupValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddGroupRequest request) {
        List<String> errors = new ArrayList<>();

        nameValidator.isNotEmpty(request.getName(), errors, "name");
        nameValidator.isNotLong(request.getName(), errors, "name", maxLen);


        return List.of();
    }
}
