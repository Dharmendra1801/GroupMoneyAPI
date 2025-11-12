package com.Uday.GroupMoney.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Tokens {
    @Id
    int tokenId;
    String username;
}
