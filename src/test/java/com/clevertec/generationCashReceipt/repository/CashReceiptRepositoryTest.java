package com.clevertec.generationCashReceipt.repository;

import com.clevertec.generationCashReceipt.model.CashReceipt;
import com.clevertec.generationCashReceipt.model.DiscountCard;
import com.clevertec.generationCashReceipt.model.Product;
import com.clevertec.generationCashReceipt.model.ShopInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CashReceiptRepositoryTest {

    @Autowired
    private CashReceiptRepository cashReceiptRepository;
    private CashReceipt cashReceipt = new CashReceipt();
    private Long idReceipt;

    @BeforeEach
    public void saveCashReceiptInDB() {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setId(1L);
        shopInfo.setShopName("My Crown");
        shopInfo.setPhoneNumber("+375 17 268 55 55");
        shopInfo.setAddress("some city, some street, some house");

        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount((byte) 20);
        discountCard.setCardNumber(100008L);
        discountCard.setId(8L);

        Set<Product> setProduct = new HashSet<>();
        Product product = new Product();
        product.setId(7L);
        product.setName("Flour 10kg");
        product.setPrice(46.99);
        setProduct.add(product);

        cashReceipt.setShopInfo(shopInfo);
        cashReceipt.setSetProduct(setProduct);
        cashReceipt.setDiscountCard(discountCard);
        cashReceipt.setDateCreation(new Timestamp(Instant.now().toEpochMilli()));
        cashReceiptRepository.save(cashReceipt);
        System.err.println(cashReceipt.toString());
    }

    @Test
    void findByDateCreationTest() {
        CashReceipt cashReceiptFromDB = cashReceiptRepository.findByDateCreation(cashReceipt.getDateCreation());
        idReceipt = cashReceiptFromDB.getCheckNumber();
        Assertions.assertEquals(cashReceipt.getDateCreation(),cashReceiptFromDB.getDateCreation());
        Assertions.assertEquals(cashReceipt.getCheckNumber(),cashReceiptFromDB.getCheckNumber());
        Assertions.assertEquals(cashReceipt.getShopInfo().getId(),cashReceiptFromDB.getShopInfo().getId());
        Assertions.assertEquals(cashReceipt.getDiscountCard().getId(),cashReceiptFromDB.getDiscountCard().getId());
        Assertions.assertEquals(cashReceipt.getSetProduct().size(),cashReceiptFromDB.getSetProduct().size());
        System.err.println(cashReceiptFromDB.toString());
        System.err.println(idReceipt);
    }

    @AfterEach
    public void deleteGenreFromDB(){
        cashReceiptRepository.deleteById(cashReceipt.getCheckNumber());
    }
}