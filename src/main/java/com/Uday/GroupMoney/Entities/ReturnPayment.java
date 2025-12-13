package com.Uday.GroupMoney.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReturnPayment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private Result result;

    @ManyToOne
    @JoinColumn(name = "payer_id", nullable = false)
    private People payer;

    @ManyToOne
    @JoinColumn(name = "payee_id", nullable = false)
    private People payee;
}
