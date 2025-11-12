package com.Uday.GroupMoney.Services;

import com.Uday.GroupMoney.Entities.Tokens;
import com.Uday.GroupMoney.Repositories.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    TokenRepo tokenRepo;

    @Autowired
    HashingService hashingService;

    public int createToken(String username) {
        int tokenId = hashingService.getHashedInt(username);

        Tokens token = new Tokens();
        token.setUsername(username);
        token.setTokenId(tokenId);
        tokenRepo.save(token);

        return tokenId;
    }

    public boolean removeToken(String token) {

        final int tokenId = Integer.parseInt(token);

        if (tokenRepo.findById(tokenId).isEmpty())
            return false;

        tokenRepo.deleteById(tokenId);
        return true;
    }
}
