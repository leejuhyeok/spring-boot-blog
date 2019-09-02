package com.hkoo.toy.blog.controller.api;

import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.repository.UserRepository;
import com.hkoo.toy.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CreateUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/check/id")
    public boolean userIdExistsCheck(@RequestParam(value = "id") String id) {
        User user = userRepository.findByEmail(id);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/create/user")
    public void signUpUser(@RequestBody Map<String,String> map){
        userService.signUpUser(map);
    }

    @PostMapping("/create/email")
    public void updateEmail(@RequestBody String map){
        log.info("email : "+map);
    }

}
