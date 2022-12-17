package com.clevertec.generationCashReceipt.controller;

import com.clevertec.generationCashReceipt.dto.DiscountCardUpdateDto;
import com.clevertec.generationCashReceipt.model.DiscountCard;
import com.clevertec.generationCashReceipt.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity DiscountCard (CRUD)
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@RestController
@RequestMapping("/discount")
public class DiscountCardController {

    private final AbstractService abstractService;

    @Autowired
    public DiscountCardController(@Qualifier("DiscountCard") AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping
    private List<DiscountCard> getAllDiscountCard() {
        return abstractService.getAll();
    }

    @GetMapping("/{id}")
    public DiscountCard getDiscountCardById(@PathVariable("id") Long id) {
        return (DiscountCard) abstractService.findById(id);
    }

    @PostMapping()
    public void saveDiscountCard(@RequestBody DiscountCardUpdateDto discountCardDto) {
        DiscountCard discountCard = discountCardDto.toDiscountCard();
        abstractService.save(discountCard);
    }

    @PutMapping("/{id}")
    public DiscountCardUpdateDto updateDiscountCard(@PathVariable("id") Long id,
                                                    @RequestBody DiscountCardUpdateDto discountCardDto) {
        discountCardDto.setCardNumber(id);
        DiscountCard discountCard = discountCardDto.toDiscountCard();
        return discountCardDto.fromDiscountCard((DiscountCard) abstractService.update(discountCard));
    }

    @DeleteMapping("/{id}")
    public void deleteDiscountCardById(@PathVariable("id") Long id) {
        abstractService.deleteById(id);
    }

}
