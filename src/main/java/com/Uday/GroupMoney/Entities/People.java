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
public class People {
    @Id
    private String name;
    private Integer totalMoneySpent;
    private Integer actualMoneySpent;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToMany(mappedBy = "peopleParticipated", cascade = CascadeType.ALL)
    private List<Event> eventsParticipated;

    @OneToMany(mappedBy = "paidBy", cascade = CascadeType.ALL)
    private List<Payment> paymentList;

    @OneToMany(mappedBy = "payer", cascade = CascadeType.ALL)
    private List<ReturnPayment> peopleToBePaid;

    @OneToMany(mappedBy = "payee", cascade = CascadeType.ALL)
    private List<ReturnPayment> toRecieveFrom;
}
