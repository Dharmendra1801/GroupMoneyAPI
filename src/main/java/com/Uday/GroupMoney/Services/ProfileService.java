package com.Uday.GroupMoney.Services;

import com.Uday.GroupMoney.Entities.Profile;
import com.Uday.GroupMoney.Repositories.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    public void save(Profile profile) {
        profileRepo.save(profile);
    }
}
