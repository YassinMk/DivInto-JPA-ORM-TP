package org.example.divintojpaormrelationaldb.service;

import org.example.divintojpaormrelationaldb.entities.Role;
import org.example.divintojpaormrelationaldb.entities.User;

public interface UserService {
    User AddNewUser(User user);
    Role AddNewRole(Role role);
    User FindUserByUserName(String userName);
    User FindUserByUserId(String userId);
    void addRoleToUser(String userName, String roleName);


}
