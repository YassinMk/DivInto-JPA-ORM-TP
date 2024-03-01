package org.example.divintojpaormrelationaldb.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.divintojpaormrelationaldb.entities.Role;
import org.example.divintojpaormrelationaldb.entities.User;
import org.example.divintojpaormrelationaldb.repositories.RoleRepository;
import org.example.divintojpaormrelationaldb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private RoleRepository roleRepository;
    private UserRepository userRepository;


    @Override
    public User AddNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role AddNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User FindUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User FindUserByUserId(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
            User user = userRepository.findByUserName(userName);
            Role role = roleRepository.findByRoleName(roleName);
            if(user.getRoles() != null){
                user.getRoles().add(role);
                role.getUsers().add(user);
                //cohérant avec base de donnée relationnelle
            }

    }

    @Override
    public User athentificate(String userName, String password) {
        User user = userRepository.findByUserName(userName);
        if(user == null) throw new RuntimeException("Username or mot de passe incorrecte");
        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Username or mot de passe incorrecte");
    }
}
