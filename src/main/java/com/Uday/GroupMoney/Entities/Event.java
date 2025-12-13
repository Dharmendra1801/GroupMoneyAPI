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
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String note;
    private Integer amount;

    @ManyToMany
    @JoinColumn(name = "people_id", nullable = false)
    private List<People> peopleParticipated;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Payment> paymentList;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;
}
