package server.request;

public class EditStudentGroupRequest {
    private long id;
    private String name;

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
