package com.Uday.GroupMoney.Controllers;

import com.Uday.GroupMoney.Entities.User;
import com.Uday.GroupMoney.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestHeader String username,
                                         @RequestHeader String password) {

        int i = authService.signIn(username,password);
        if (i==-1)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong Password");
        else if (i==0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wrong Username");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).header("tokenId",String.valueOf(i)).body("Sign in Successful");
    }

    @PostMapping("/sign-out")
    public ResponseEntity<String> signOut(@RequestHeader String tokenId) {

        if (authService.signOut(tokenId))
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Sign out Successful");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not signed in!");
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody User user) {

        if (authService.signUp(user)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Sign up Successful");
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("User already exists");
    }

    @DeleteMapping("/delete-acc")
    public ResponseEntity<String> deleteAcc(@RequestBody User user) {

        int i = authService.deleteAcc(user);
        if (i==-1)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong Password");
        else if (i==0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Wrong Username");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).header("tokenId",String.valueOf(i)).body("Account deleted");
    }
}
