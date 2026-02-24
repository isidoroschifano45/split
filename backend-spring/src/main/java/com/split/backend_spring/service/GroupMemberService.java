package com.split.backend_spring.service;

import com.split.backend_spring.model.GroupMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupMemberService {
    GroupMember save(GroupMember groupMember);
    GroupMember findById(Long id);
    List<GroupMember> findAll();


}
