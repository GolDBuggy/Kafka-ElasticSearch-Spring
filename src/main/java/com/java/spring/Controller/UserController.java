package com.java.spring.Controller;

import com.java.spring.Model.User;
import com.java.spring.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(value = "User Model Document")
public class UserController {

    private final UserService service;

    @GetMapping("/all")
    @ApiOperation(value = "Get All Method",notes = "get all users")
    public ResponseEntity<Iterable<User>> getAll(){
        return  ResponseEntity.ok(service.getAll());
    }


    @PostMapping("/save")
    @ApiOperation(value = "Save Method",notes = "save user")
    public User save(@RequestBody @ApiParam(value = "user") User user){
        service.save(user);
        return  user;
    }
}