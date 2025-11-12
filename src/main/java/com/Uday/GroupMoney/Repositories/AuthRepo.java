package com.Uday.GroupMoney.Repositories;

import com.Uday.GroupMoney.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<User, String> {
}
