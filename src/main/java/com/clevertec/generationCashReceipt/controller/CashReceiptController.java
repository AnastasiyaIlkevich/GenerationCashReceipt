package com.clevertec.generationCashReceipt.controller;

import com.clevertec.generationCashReceipt.dto.CashReceiptSaveDto;
import com.clevertec.generationCashReceipt.dto.CashReceiptUpdateDto;
import com.clevertec.generationCashReceipt.model.CashReceipt;
import com.clevertec.generationCashReceipt.model.ShopInfo;
import com.clevertec.generationCashReceipt.service.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity CashReceipt (CRUD)
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@RestController
@RequestMapping("/receipt")
public class CashReceiptController {

    private final AbstractService abstractService;

    @Autowired
    public CashReceiptController(@Qualifier("CashReceipt") AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping
    private List<CashReceipt> getAllCashReceipt() {
        return abstractService.getAll();
    }

    @GetMapping("/{id}")
    public CashReceipt getCashReceiptById(@PathVariable("id") Long id) {
        return (CashReceipt) abstractService.findById(id);
    }

    @PostMapping()
    public void saveNewCashReceiptWithDefaultStore(@RequestBody CashReceiptSaveDto cashReceiptDto) {
        CashReceipt cashReceipt = cashReceiptDto.toCashReceipt();
        abstractService.save(cashReceipt);
    }

    @PostMapping("/shop/{id}")
    public void saveNewCashReceiptWithStoreId(@PathVariable("id") Long id,
                                              @RequestBody CashReceiptSaveDto cashReceiptDto) {
        CashReceipt cashReceipt = cashReceiptDto.toCashReceipt();
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setId(id);
        cashReceipt.setShopInfo(shopInfo);
        abstractService.save(cashReceipt);
    }

    @PutMapping("/{id}")
    public CashReceiptUpdateDto updateCashReceipt(@PathVariable("id") Long id,
                                                  @RequestBody CashReceiptUpdateDto receiptUpdateDto) {
        receiptUpdateDto.setCheckNumber(id);
        CashReceipt cashReceipt = receiptUpdateDto.toCashReceipt();
        return receiptUpdateDto.fromCashReceipt((CashReceipt) abstractService.update(cashReceipt));
    }

    @DeleteMapping("/{id}")
    public void deleteCashReceiptById(@PathVariable("id") Long id) {
        abstractService.deleteById(id);
    }
}
