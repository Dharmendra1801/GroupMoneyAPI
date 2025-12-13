package com.Uday.GroupMoney.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;
    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    private History history;
}
