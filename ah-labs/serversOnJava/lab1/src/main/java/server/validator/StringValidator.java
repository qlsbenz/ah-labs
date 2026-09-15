package server.validator;

import java.util.ArrayList;
import java.util.List;

public class StringValidator {
    private final int maxLength;

    public StringValidator(int maxLength) {
        this.maxLength = maxLength;
    }

    public List<String> validate(String value, String fieldName) {
        List<String> errors = new ArrayList<>();

        if (value == null) {
            errors.add(fieldName + " cannot be null");
            return errors;
        }

        if (value.trim().isEmpty()) {
            errors.add(fieldName + " cannot be empty");
        }

        if (value.length() > maxLength) {
            errors.add(fieldName + " must not contain more " + maxLength + " characters");
        }
        return errors;
    }
}
