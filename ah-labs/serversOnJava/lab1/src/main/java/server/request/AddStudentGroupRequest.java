package server.request;

public class AddStudentGroupRequest {
    private String name;

    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
