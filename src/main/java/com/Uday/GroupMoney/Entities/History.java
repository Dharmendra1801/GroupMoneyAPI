package com.Uday.GroupMoney.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "history", cascade = CascadeType.ALL)
    private List<Trip> tripList;
    @OneToOne
    @JoinColumn(name = "profile_id", unique = true, nullable = false)
    private Profile profile;
}
