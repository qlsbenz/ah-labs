package server.validators.primitive;

import server.model.AttendanceStatus;
import server.model.StudentStatus;

import java.util.List;

public class StatusAttendanceValidator {
    public List<String> isValidStatus(String status, List<String> errors, String fieldName) {
        try {
            AttendanceStatus.valueOf(status.trim().toUpperCase());
        } catch(Exception e) {
            errors.add(String.format("%s: should be correct status", fieldName));
        }
        return errors;
    }
}
