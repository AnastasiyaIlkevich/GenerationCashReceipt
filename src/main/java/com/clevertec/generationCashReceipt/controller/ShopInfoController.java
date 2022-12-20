package com.clevertec.generationCashReceipt.controller;

import com.clevertec.generationCashReceipt.dto.ShopUpdateDto;
import com.clevertec.generationCashReceipt.model.ShopInfo;
import com.clevertec.generationCashReceipt.service.AbstractService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity ShopInfo (CRUD)
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@Log4j2
@RestController
@RequestMapping("/shop")
public class ShopInfoController {


    private final AbstractService abstractService;

    @Autowired
    public ShopInfoController(@Qualifier("ShopInfo") AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping
    private List<ShopInfo> getAllShopInfo() {
        log.debug(ShopInfoController.class + ". Start method getAllShopInfo");
        return abstractService.getAll();
    }

    @GetMapping("/{id}")
    public ShopInfo getShopInfoById(@PathVariable("id") Long id) {
        log.info("Start method getShopInfoById with id = " + id);
        return (ShopInfo) abstractService.findById(id);
    }

    @PostMapping()
    public void saveShopInfo(@RequestBody ShopUpdateDto shopDto) {
        ShopInfo shopInfo = shopDto.toShopInfo();
        log.info("Start method saveShopInfo " + shopInfo);
        abstractService.save(shopInfo);
    }

    @PutMapping("/{id}")
    public ShopUpdateDto updateShopInfo(@PathVariable("id") Long id,
                                        @RequestBody ShopUpdateDto shopDto) {
        shopDto.setId(id);
        ShopInfo shopInfo = shopDto.toShopInfo();
        log.info(String.format("Start method updateShopInfo with id = %d " +
                "and shopInfo = %s", id, shopInfo));
        return shopDto.fromShopInfo((ShopInfo) abstractService.update(shopInfo));
    }

    @DeleteMapping("/{id}")
    public void deleteShopInfoById(@PathVariable("id") Long id) {
        log.info("Start method deleteShopInfoById with id = " + id);
        abstractService.deleteById(id);
    }

}
