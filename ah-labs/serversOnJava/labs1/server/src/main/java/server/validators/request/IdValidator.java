package server.validators.request;

import server.DTO.request.IdRequest;

import java.util.ArrayList;
import java.util.List;

public class IdValidator implements RequestValidator<IdRequest> {
    private final server.validators.primitive.IdValidator idValidator;


    public IdValidator(server.validators.primitive.IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(IdRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.isId(request.getId(), errors, "id");

        return List.of();
    }
}
