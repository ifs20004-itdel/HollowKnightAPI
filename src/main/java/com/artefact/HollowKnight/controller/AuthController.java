package com.artefact.HollowKnight.controller;


import com.artefact.HollowKnight.dto.AuthRequest;
import com.artefact.HollowKnight.model.UserCredential;
import com.artefact.HollowKnight.response.ResponseHandler;
import com.artefact.HollowKnight.service.AuthService;
import com.artefact.HollowKnight.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<Object> addNewUser(@RequestBody UserCredential user){
        return ResponseHandler.responseBuilder(
                "User add successfully",
                HttpStatus.OK,
                service.saveUser(user)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<Object> getToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return ResponseHandler.responseBuilder(
                    "Token generate successfully",
                    HttpStatus.OK,
                    service.generateToken(authRequest.getUsername())
            );
        }else{
            return ResponseHandler.responseBuilder(
                    "user not found",
                    HttpStatus.FORBIDDEN,
                    "-"
            );
        }
    }


//    @GetMapping("validate")
//    public String validateToken(@RequestParam("token") String token){
//        service.validateToken(token);
//        return "Token is valid";
//    }
}
