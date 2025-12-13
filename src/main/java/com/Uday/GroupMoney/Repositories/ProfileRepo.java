package com.Uday.GroupMoney.Repositories;

import com.Uday.GroupMoney.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile,Long> {
}
