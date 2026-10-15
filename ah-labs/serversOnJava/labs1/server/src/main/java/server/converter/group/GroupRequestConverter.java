package server.converter.group;

import server.DTO.request.group.AddGroupRequest;
import server.DTO.request.group.EditStudentGroupRequest;
import server.entity.GroupEntity;

import java.time.Instant;

public class GroupRequestConverter {
    public GroupEntity toEntity(AddGroupRequest request) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new GroupEntity(
                null,
                request.getName(),
                milliseconds,
                milliseconds
        );
    }

    public GroupEntity toEntity(EditStudentGroupRequest request, long createdAt) {
        Instant correctTime = Instant.now();
        long milliseconds = correctTime.toEpochMilli();
        return new GroupEntity(
                request.getId(),
                request.getName(),
                createdAt,
                milliseconds
        );
    }
}
