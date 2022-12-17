package com.clevertec.generationCashReceipt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * An object representing the DiscountCard
 *
 * @version 1.0
 * @author Ilkevich Anastasiya
 */

@Entity
@Table(name="discount_card")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DiscountCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_discount_card")
    private Long cardNumber;
    @Column (name = "discount")
    private byte discount;
   // private Long ransomAmount;


    @OneToMany(mappedBy="discountCard", cascade = CascadeType.DETACH)
    private Set<CashReceipt> cashReceiptSet;
}

