package com.clevertec.generationCashReceipt.service.impl;

import com.clevertec.generationCashReceipt.exceptions.IdNotFoundException;
import com.clevertec.generationCashReceipt.model.DiscountCard;
import com.clevertec.generationCashReceipt.repository.DiscountCardRepository;
import com.clevertec.generationCashReceipt.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementation of the logic of the entity DiscountCard
 * for working with the database
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@Component("DiscountCard")
public class DiscountCardServiceImpl implements AbstractService<DiscountCard, Long> {

    private final DiscountCardRepository discountCardRepository;

    @Autowired
    public DiscountCardServiceImpl(DiscountCardRepository discountCardRepository) {
        this.discountCardRepository = discountCardRepository;
    }

    @Override
    public List<DiscountCard> getAll() {
        return discountCardRepository.findAll();
    }

    @Override
    public DiscountCard findById(Long id) {
        return discountCardRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    //TODO - develop a logic for generating IDs with 100_000
    @Override
    public void save(DiscountCard discountCard) {
        discountCardRepository.save(discountCard);
    }

    @Override
    public DiscountCard update(DiscountCard discountCard) {
        discountCardRepository.findById(discountCard.getId()).orElseThrow(IdNotFoundException::new);
        return discountCardRepository.save(discountCard);
    }

    @Override
    public void deleteById(Long id) {
        discountCardRepository.deleteById(id);
    }
}
