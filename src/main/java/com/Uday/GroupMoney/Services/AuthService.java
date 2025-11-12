package com.Uday.GroupMoney.Services;

import com.Uday.GroupMoney.Entities.User;
import com.Uday.GroupMoney.Repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthRepo authRepo;

    @Autowired
    HashingService hashingService;

    public int signIn(String username, String password) {
        User user = authRepo.findById(username).orElse(null);
        if (user!=null) {
            if (!hashingService.getHashedString(password).equals(user.getPassword())) return -1;
        }
        else return 0;
        return tokenService.createToken(username);
    }

    public boolean signOut(String token) {
        return tokenService.removeToken(token);
    }

    public boolean signUp(User user) {
        if (authRepo.existsById(user.getUsername())) return false;
        user.setPassword(hashingService.getHashedString(user.getPassword()));
        authRepo.save(user);
        return true;
    }

    public int deleteAcc(User user) {
        User user_DB = authRepo.findById(user.getUsername()).orElse(null);
        if (user_DB!=null) {
            if (!hashingService.getHashedString(user.getPassword()).equals(user_DB.getPassword())) return -1;
        }
        else return 0;
        authRepo.deleteById(user.getUsername());
        return 1;
    }
}
