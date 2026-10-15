package server.converter.group;

import server.DTO.response.group.GroupResponse;
import server.entity.GroupEntity;

public class GroupEntityConverter {
    public GroupResponse toResponse(GroupEntity group) {
        return new GroupResponse(
                group.getId(),
                group.getName()
        );
    }
}
