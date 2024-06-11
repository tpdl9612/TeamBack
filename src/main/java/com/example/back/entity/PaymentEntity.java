package com.example.back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "payment")
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String amount;
    private String paymentKey;
}
