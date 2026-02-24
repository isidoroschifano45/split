package com.split.backend_spring.service;

import com.split.backend_spring.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {

    // Metodi CRUD di base
    Group findById(Long id);
    Group save(Group group);
    void deleteGroupById(Long id);
    List<Group> findAll();

    // Metodi specifici per i gruppi
    Group updateGroup(Long id, Group group);
    List<Group> findByCreatorId(Long creatorId);
    boolean existsById(Long id);

    // Metodi per statistiche del gruppo
    Long countMembersByGroupId(Long groupId);
    Double getTotalExpensesByGroupId(Long groupId);
}