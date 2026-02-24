package com.split.backend_spring.dto.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserGroupMemberResponse {
    private String firstName;
    private String lastName;
    private String username;
}
