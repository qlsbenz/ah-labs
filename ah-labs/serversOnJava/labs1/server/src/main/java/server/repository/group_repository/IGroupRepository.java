package server.repository.group_repository;

import server.entity.GroupEntity;

import java.util.List;

public interface IGroupRepository {
    GroupEntity addGroup(GroupEntity group);
    GroupEntity getById(long id);
    List<GroupEntity> getAll();
    GroupEntity getByName(String name);
    void edit(GroupEntity group);
    void deleteById(long id);
}
