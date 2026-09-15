package server.response;

import java.util.List;

public class GroupListResponse {
    private List<GroupResponse> groups;

    public GroupListResponse(List<GroupResponse> groups) {
        this.groups = groups;
    }

    public List<GroupResponse> getGroups() {
        return groups;
    }
}