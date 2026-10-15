package server.DTO.request.group;

public class AddGroupRequest {
    private final String name;

    public AddGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
