package server.DTO.request.group;

public class EditStudentGroupRequest {
    private final long id;
    private final String name;

    public EditStudentGroupRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
