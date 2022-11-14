package com.devclass.camadasormdto.controllers;

import com.devclass.camadasormdto.dto.UserDTO;
import com.devclass.camadasormdto.entities.User;
import com.devclass.camadasormdto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }
}
