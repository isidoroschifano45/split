package com.split.backend_spring.service.impl;

import com.split.backend_spring.exception.group.GroupNotFoundException;
import com.split.backend_spring.model.Group;
import com.split.backend_spring.repository.GroupMemberRepository;
import com.split.backend_spring.repository.GroupRepository;
import com.split.backend_spring.repository.UserRepository;
import com.split.backend_spring.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepo;
    private final UserRepository userRepo;
    private final GroupMemberRepository groupMemberRepo;

    @Override
    public Group findById(Long id) {
        return groupRepo.findById(id).orElseThrow(() -> new GroupNotFoundException("Group with id: " + id + "not found"));
    }

    @Override
    public Group save(Group group) {
        return groupRepo.save(group);
    }

    @Override
    public void deleteGroupById(Long id) {
        Group g = groupRepo.findById(id).orElseThrow(() -> new GroupNotFoundException("Group with id: " + id + "not found"));
        groupRepo.delete(g);
    }

    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public Group updateGroup(Long id, Group group) {
        return null;
    }

    @Override
    public List<Group> findByCreatorId(Long creatorId) {
        return List.of();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Long countMembersByGroupId(Long groupId) {
        return 0L;
    }

    @Override
    public Double getTotalExpensesByGroupId(Long groupId) {
        return 0.0;
    }


}
