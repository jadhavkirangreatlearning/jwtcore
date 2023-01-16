package com.csi.controller;

import com.csi.model.AuthRequest;
import com.csi.model.User;
import com.csi.service.UserServiceImpl;
import com.csi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("WELCOME TO FINTECH CSI PUNE");
    }

    @PostMapping("/savedata")
    public ResponseEntity<User> saveData(@RequestBody User user){
        return ResponseEntity.ok(userServiceImpl.saveData(user));

    }
    @GetMapping("/getalldata")
    public ResponseEntity<List<User>> getAllData(){
        return ResponseEntity.ok(userServiceImpl.getAllDatta());
    }

    @PutMapping("/updatedata/{userId}")
    public ResponseEntity<User> updateData(@PathVariable int userId, @RequestBody User user){

        // Exception code goes here
        return ResponseEntity.ok(userServiceImpl.updateData(user));
    }

    @DeleteMapping("/deletedatabyid/{userId}")
    public ResponseEntity<String> deleteData(@PathVariable int userId){
        userServiceImpl.deleteData(userId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Incorrect un/pwd");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
