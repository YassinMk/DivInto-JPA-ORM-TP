package org.example.divintojpaormrelationaldb;

import org.example.divintojpaormrelationaldb.entities.Role;
import org.example.divintojpaormrelationaldb.entities.User;
import org.example.divintojpaormrelationaldb.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DivIntoJpaOrmRelationalDbApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DivIntoJpaOrmRelationalDbApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User user = new User();
            user.setUserName("user1");
            user.setPassword("1234");
            userService.AddNewUser(user);

            User user2 = new User();
            user2.setUserName("user2");
            user2.setPassword("1235");
            userService.AddNewUser(user2);

            Stream.of("STUDENT","ADMIN","TEACHER").forEach(role -> {
                Role role1 = new Role();
                role1.setRoleName(role);
                userService.AddNewRole(role1);
            });

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","ADMIN");
            userService.addRoleToUser("user2","TEACHER");


        };
    }
}
