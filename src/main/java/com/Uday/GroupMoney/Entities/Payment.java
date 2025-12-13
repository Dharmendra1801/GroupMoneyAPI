package com.Uday.GroupMoney.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "people_id", nullable = false)
    private People paidBy;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

}
