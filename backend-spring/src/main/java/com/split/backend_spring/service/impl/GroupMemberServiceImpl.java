package com.split.backend_spring.service.impl;

import com.split.backend_spring.exception.group.GroupNotFoundException;
import com.split.backend_spring.exception.groupmember.GroupMemberNotFoundException;
import com.split.backend_spring.model.Group;
import com.split.backend_spring.model.GroupMember;
import com.split.backend_spring.model.User;
import com.split.backend_spring.repository.GroupMemberRepository;
import com.split.backend_spring.repository.GroupRepository;
import com.split.backend_spring.repository.UserRepository;
import com.split.backend_spring.service.GroupMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupMemberServiceImpl implements GroupMemberService {

    private final GroupMemberRepository groupMemberRepo;
    private final UserRepository userRepo;
    private final GroupRepository groupRepo;

    @Override
    public GroupMember save(GroupMember groupMember) {
        return groupMemberRepo.save(groupMember);
    }

    @Override
    public GroupMember findById(Long id) {
        return groupMemberRepo.findById(id)
                .orElseThrow(() -> new GroupMemberNotFoundException("Group Member with id: " + id + " not found"));
    }

    @Override
    public List<GroupMember> findAll() {
        return groupMemberRepo.findAll();
    }

    public List<GroupMember> findByGroupId(Long groupId) {
        if (!groupRepo.existsById(groupId)) {
            throw new GroupNotFoundException("Group with id: " + groupId + " not found");
        }
        return groupMemberRepo.findByGroupId(groupId);
    }

    public List<GroupMember> findByUserId(Long userId) {
        return groupMemberRepo.findByUserId(userId);
    }

    public GroupMember addMemberToGroup(Long groupId, Long userId) {
        Group group = groupRepo.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("Group with id: " + groupId + " not found"));

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id: " + userId + " not found"));

        GroupMember groupMember = new GroupMember();
        groupMember.setGroup(group);
        groupMember.setUser(user);

        return groupMemberRepo.save(groupMember);
    }

    public void removeMemberFromGroup(Long groupMemberId) {
        if (!groupMemberRepo.existsById(groupMemberId)) {
            throw new GroupMemberNotFoundException("Group Member with id: " + groupMemberId + " not found");
        }
        groupMemberRepo.deleteById(groupMemberId);
    }

    public void removeMemberFromGroupByUserAndGroup(Long groupId, Long userId) {
        GroupMember groupMember = groupMemberRepo.findByGroupIdAndUserId(groupId, userId)
                .orElseThrow(() -> new GroupMemberNotFoundException("Member not found in this group"));
        groupMemberRepo.delete(groupMember);
    }
}
