package com.ys.springbootdemo.controllers;

import com.ys.springbootdemo.models.User;
import com.ys.springbootdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @PostMapping(path = "/add")
//    public @ResponseBody String add(@RequestParam String name, @RequestParam String email) {
//        User user = new User();
//        user.setName(name);
//        user.setEmail(email);
//        userRepository.save(user);
//        return "Added";
//    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "Added";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<User> getUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PutMapping(path = "/update")
    public @ResponseBody
    String updateUser(@RequestBody User user) {
        User sessionUser = userRepository.findById(user.getId()).get();
        if (sessionUser != null) {
            sessionUser.setName(user.getName());
            sessionUser.setEmail(user.getEmail());
            userRepository.save(sessionUser);
            return "Updated";
        }
        return "Not found";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody
    String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "Deleted";
    }
}
