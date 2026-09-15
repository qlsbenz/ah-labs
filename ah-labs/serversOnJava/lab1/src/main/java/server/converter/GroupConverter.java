package server.converter;

import server.entity.GroupEntity;
import server.model.Group;
import server.request.AddStudentGroupRequest;
import server.request.EditStudentGroupRequest;
import server.response.GroupResponse;

public class GroupConverter {

    public GroupEntity fromRequest(AddStudentGroupRequest request, long id, long createdAt, long updatedAt) {

        return new GroupEntity(id, request.getName(), createdAt, updatedAt
        );
    }

    public GroupEntity fromRequest(EditStudentGroupRequest request, GroupEntity oldEntity, long updatedAt) {

        return new GroupEntity(oldEntity.getId(), request.getName(), oldEntity.getCreatedAt(), updatedAt
        );
    }

    public Group toModel(GroupEntity entity) {
        return new Group(entity.getId(), entity.getName()
        );
    }

    public GroupResponse toResponse(Group model) {
        return new GroupResponse(model.getId(), model.getName()
        );
    }
}