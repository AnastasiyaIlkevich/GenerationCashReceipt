package com.clevertec.generationCashReceipt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * An object representing a ShopInfo that contains the information.
 *
 * @version 1.0
 * @author Ilkevich Anastasiya
 */

@Entity
@Table(name="shop")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ShopInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_shop")
    private Long id;
    @Column (name = "shop_name")
    private String shopName;
    @Column (name = "address")
    private String address;
    @Column (name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy="shopInfo", cascade = CascadeType.DETACH)
    private Set<CashReceipt> cashReceiptSet;

}
