package com.clevertec.generationCashReceipt.service.impl;

import com.clevertec.generationCashReceipt.exceptions.IdNotFoundException;
import com.clevertec.generationCashReceipt.model.CashReceipt;
import com.clevertec.generationCashReceipt.model.ShopInfo;
import com.clevertec.generationCashReceipt.repository.CashReceiptRepository;
import com.clevertec.generationCashReceipt.repository.ShopInfoRepository;
import com.clevertec.generationCashReceipt.service.AbstractService;
import com.clevertec.generationCashReceipt.service.GenerateCashRecaipt.GenerateRecaiptFile;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * Implementation of the logic of the entity CashReceipt
 * for working with the database
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */
@Component("CashReceipt")
public class CashReceiptServiceImpl implements AbstractService<CashReceipt, Long> {

    private static final Long DEFAULT_SHOP = 1L;

    private final CashReceiptRepository cashReceiptRepository;
    private final ShopInfoRepository shopInfoRepository;
    private final GenerateRecaiptFile generateRecaiptFile;

    public CashReceiptServiceImpl(CashReceiptRepository cashReceiptRepository, ShopInfoRepository shopInfoRepository, GenerateRecaiptFile generateRecaiptFile) {
        this.cashReceiptRepository = cashReceiptRepository;
        this.shopInfoRepository = shopInfoRepository;
        this.generateRecaiptFile = generateRecaiptFile;
    }

    @Override
    public List<CashReceipt> getAll() {
        return cashReceiptRepository.findAll();
    }

    @Override
    public CashReceipt findById(Long id) {
        return cashReceiptRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    @Override
    public void save(CashReceipt cashReceipt) {


        if (cashReceipt.getShopInfo() == null) {
            ShopInfo shopInfo = shopInfoRepository.findById(DEFAULT_SHOP).orElseThrow(IdNotFoundException::new);
            cashReceipt.setShopInfo(shopInfo);
        } else {
            ShopInfo shopInfo = shopInfoRepository.findById(cashReceipt.getShopInfo().getId())
                    .orElseThrow(IdNotFoundException::new);
            cashReceipt.setShopInfo(shopInfo);
        }
        //    private Long checkNumber;             -null auto generat
        //    private Timestamp dateCreation;       -null auto generat
        //    private Set<Product> setProduct;      Yes
        //    private ShopInfo shopInfo;            -null
        //    private DiscountCard discountCard;    Yes

        cashReceipt.setDateCreation(new Timestamp(Instant.now().toEpochMilli()));
        cashReceiptRepository.save(cashReceipt);

        generateRecaiptFile.createFile(cashReceiptRepository.findByDateCreation(cashReceipt.getDateCreation())
                .getCheckNumber());
        generateRecaiptFile.writeFile();
    }


    @Override
    public CashReceipt update(CashReceipt cashReceipt) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        cashReceiptRepository.deleteById(id);

    }
}
