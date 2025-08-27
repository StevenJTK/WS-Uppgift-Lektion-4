package com.sti.steven.controller;

import com.sti.steven.model.CustomUser;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    List<CustomUser> userList = new ArrayList<>(
            List.of(
                    new CustomUser(0, "Steven", "123", true),
                    new CustomUser(1, "Kristoffer", "345", true),
                    new CustomUser(2, "Lilly", "678", true),
                    new CustomUser(3, "Boris", "123", true)
            )
    );


    @GetMapping("/")
    public List<CustomUser> test() {
        return userList;
    }

    @GetMapping("/users/id")
    public CustomUser getUser(@PathVariable("id") String id) {
        System.out.println(userList.get(Integer.parseInt(id)));

        for (CustomUser user: userList) {
            if (user.id() == Integer.parseInt(id)) {
                System.out.println(user);

                return user;
            }
        }
        return null;
    }

    @DeleteMapping("/{username}")
    public CustomUser deleteUser(@PathVariable("username") String username) {

        CustomUser customUserToBeDeleted;

        for (int i = 0; i < userList.size(); i++) {
            if (Objects.equals(userList.get(i).username(), username)) {
                customUserToBeDeleted = userList.get(i);
                userList.remove(customUserToBeDeleted);

                return customUserToBeDeleted;
            }
        }
    
        return null;
    }
}
