package org.example.controller;

import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    @CrossOrigin
    public @ResponseBody Map<String, Object> createUser(@RequestBody User user) {
        Map<String, Object> object = new HashMap<>();
        if (!userService.createUser(user)) {
            user.setMessage("Bad_request");
            user.setStatus(400);
            object.put("message", user.getMessage());
            object.put("status", user.getStatus());
            return object;
        }
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setMessage("OK");
        user.setStatus(200);
        object.put("message", user.getMessage());
        object.put("status", user.getStatus());
        return object;
    }

/*let response = await fetch('https://backend-web-service-ovks.onrender.com/login', {
            method: "POST", // *GET, POST, PUT, DELETE, etc.
            mode: "cors", // no-cors, *cors, same-origin
            cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
            credentials: "same-origin", // include, *same-origin, omit
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                username: login,
                password: password
            })
        })*/
}
