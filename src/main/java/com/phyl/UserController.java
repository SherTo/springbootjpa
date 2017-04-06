package com.phyl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xh on 2017/4/6.
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("add")
    public User addUser() {
        return userRepository.save(new User("phyl", 22));
    }

    @GetMapping("edit/{id}")
    public User editUser(@PathVariable int id) {
        User user = userRepository.findOne(id);
        user.setName("sher");
        return userRepository.save(user);
    }

    @GetMapping("find")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("findByName/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userRepository.findUserByName(name);
    }

    @GetMapping("getByName/{name}")
    public List<User> getByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }
}
