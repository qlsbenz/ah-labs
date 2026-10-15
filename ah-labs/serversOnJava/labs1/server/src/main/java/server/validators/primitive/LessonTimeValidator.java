package server.validators.primitive;

import java.util.List;

public class LessonTimeValidator {
    public List<String> correctTime(long start, long end, List<String> errors, String fieldName) {
        if (start > end) {
            errors.add(String.format("%s: should be less than end time", fieldName));
        }
        return errors;
    }
}
