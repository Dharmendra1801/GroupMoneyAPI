package com.Uday.GroupMoney.Services;

import org.springframework.stereotype.Service;

@Service
public class HashingService {
    public int getHashedInt(String word) {
        return  Math.abs(word.
                substring(0,word.length()/2).
                toUpperCase().hashCode())
                +
                Math.abs(word.
                substring(word.length()/2).
                toUpperCase().hashCode());
    }
    public String getHashedString(String word) {
        return  String.valueOf(Math.abs(word.
                substring(0,word.length()/2).
                toUpperCase().hashCode())
                +
                Math.abs(word.
                        substring(word.length()/2).
                        toUpperCase().hashCode()));
    }
}
