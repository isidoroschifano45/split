package com.split.backend_spring.mapper.group;

import com.split.backend_spring.dto.request.group.GroupRequest;
import com.split.backend_spring.dto.response.group.GroupResponse;
import com.split.backend_spring.model.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    public Group toGroup(GroupRequest request) {
        if (request == null) {
            return null;
        }

        Group group = new Group();
        group.setName(request.getName());
        group.setDescription(request.getDescription());

        return group;
    }

    public GroupResponse toResponse(Group group) {
        if (group == null) {
            return null;
        }

        GroupResponse response = new GroupResponse();
        response.setId(group.getId());
        response.setName(group.getName());
        response.setDescription(group.getDescription());

        return response;
    }
}
