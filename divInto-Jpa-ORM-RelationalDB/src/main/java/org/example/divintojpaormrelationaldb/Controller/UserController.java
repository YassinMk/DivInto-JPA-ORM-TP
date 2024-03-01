package org.example.divintojpaormrelationaldb.Controller;

import lombok.AllArgsConstructor;
import org.example.divintojpaormrelationaldb.entities.User;
import org.example.divintojpaormrelationaldb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("/user/${userName}")
    public User user(@PathVariable String userName){
        User user = userService.FindUserByUserName(userName);
        return user;
    }

}
