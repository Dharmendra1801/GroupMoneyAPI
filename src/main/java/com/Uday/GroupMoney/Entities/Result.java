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
public class Result {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "trip_id", unique = true, nullable = false)
    private Trip trip;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL)
    private List<ReturnPayment> returnPaymentList;
}
