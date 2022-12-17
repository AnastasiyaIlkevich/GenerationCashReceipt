package com.clevertec.generationCashReceipt.service.impl;

import com.clevertec.generationCashReceipt.exceptions.IdNotFoundException;
import com.clevertec.generationCashReceipt.model.ShopInfo;
import com.clevertec.generationCashReceipt.repository.ShopInfoRepository;
import com.clevertec.generationCashReceipt.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ShopInfo")
public class ShopInfoServiceImpl implements AbstractService<ShopInfo, Long> {

    private final ShopInfoRepository shopInfoRepository;

    @Autowired
    public ShopInfoServiceImpl(ShopInfoRepository shopInfoRepository) {
        this.shopInfoRepository = shopInfoRepository;
    }

    @Override
    public List<ShopInfo> getAll() {
        return shopInfoRepository.findAll();
    }

    @Override
    public ShopInfo findById(Long id) {
        return shopInfoRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    @Override
    public void save(ShopInfo shopInfo) {
        shopInfoRepository.save(shopInfo);
    }

    @Override
    public ShopInfo update(ShopInfo shopInfo) {
        shopInfoRepository.findById(shopInfo.getId()).orElseThrow(IdNotFoundException::new);
        return shopInfoRepository.save(shopInfo);
    }

    @Override
    public void deleteById(Long id) {
        shopInfoRepository.deleteById(id);
    }
}
