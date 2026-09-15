package server.validator;

import server.request.IdRequest;

import java.util.ArrayList;
import java.util.List;

public class IdRequestValidator
        implements RequestValidator<IdRequest> {

    private final IdValidator idValidator;

    public IdRequestValidator() {
        this.idValidator = new IdValidator();
    }

    @Override
    public List<String> validate(IdRequest request) {
        List<String> errors = new ArrayList<>();

        if (request == null) {
            errors.add("Request cannot be null");
            return errors;
        }
        errors.addAll(
                idValidator.validate(request.getId())
        );
        return errors;
    }
}