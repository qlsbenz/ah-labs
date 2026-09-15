package server.validator;

import java.util.ArrayList;
import java.util.List;

public class IdValidator {
    public List<String> validate(long id) {
        List<String> errors = new ArrayList<>();

        if (id <= 0) {
            errors.add("id must be positive");
        }
        return errors;
    }
}
