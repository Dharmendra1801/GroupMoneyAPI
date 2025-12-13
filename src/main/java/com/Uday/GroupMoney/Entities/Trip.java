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
public class Trip {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "history_id", nullable = false)
    private History history;

    private String tripName;
    private Integer totalSpent;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<People> peopleList;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Event> eventList;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private Result result;
}
