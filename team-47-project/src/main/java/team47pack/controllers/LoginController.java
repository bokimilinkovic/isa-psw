package team47pack.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import team47pack.models.User;
import team47pack.models.dto.LoginRequest;
import team47pack.models.dto.RegisterRequest;
import team47pack.service.LoginService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
public class LoginController {

    @Autowired
    LoginService loginservice;

    @PostMapping(value="/register", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req){
       boolean b = loginservice.register(req);
       if (b==true){
           return ResponseEntity.ok("Successful");
       }
       return ResponseEntity.status(400).body("Invalid information");
    }

    @PostMapping(value="/login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        //ret = );
        User u = loginservice.login(request.getEmail(),request.getPassword());
        System.out.println(request.getEmail() + request.getPassword());
        String response = "";

        if (u == null)
            response = "null";
        else
            response = "{\"email\":\"" + u.getEmail() + "\"}";

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping(value="/test")
    public String test(){
        return "Uspesnoo";
    }

}
