package com.clevertec.generationCashReceipt.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * An object representing the Product
 *
 * @version 1.0
 * @author Ilkevich Anastasiya
 */

@Entity
@Table(name="product")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_product")
    private Long id;
    @Column (name = "product_name")
    private String name;
    @Column (name = "price")
    private Double price;
//    @Transient
//    private Long count;

    @ManyToMany(mappedBy = "setProduct")
    private Set<CashReceipt> cashReceiptSet;


}
