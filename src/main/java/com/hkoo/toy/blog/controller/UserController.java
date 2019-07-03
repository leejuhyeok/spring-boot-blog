package com.hkoo.toy.blog.controller;

import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/check/id")
    public boolean userIdExistsCheck(@RequestParam(value = "id") String id){
        User user = userRepository.findByEmail(id);
        log.info("id : "+id);

        return (user.equals(null));
    }
}
