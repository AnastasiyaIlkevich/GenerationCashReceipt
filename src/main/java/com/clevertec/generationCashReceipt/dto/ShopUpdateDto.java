package com.clevertec.generationCashReceipt.dto;


import com.clevertec.generationCashReceipt.model.ShopInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of a data transfer object designed
 * to convert json into a ShopInfo object and vice versa.
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ShopUpdateDto {

    private Long id;
    private String shopName;
    private String address;
    private String phoneNumber;

    public ShopInfo toShopInfo() {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setId(this.id);
        shopInfo.setShopName(this.shopName);
        shopInfo.setAddress(this.address);
        shopInfo.setPhoneNumber(this.phoneNumber);
        return shopInfo;
    }

    public ShopUpdateDto fromShopInfo(ShopInfo shopInfo) {
        ShopUpdateDto shopDto = new ShopUpdateDto();
        shopDto.setId(shopInfo.getId());
        shopDto.setShopName(shopInfo.getShopName());
        shopDto.setAddress(shopInfo.getAddress());
        shopDto.setPhoneNumber(shopInfo.getPhoneNumber());
        return shopDto;
    }
}
