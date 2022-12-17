package com.clevertec.generationCashReceipt.service.impl;

import com.clevertec.generationCashReceipt.exceptions.ProductNotFoundException;
import com.clevertec.generationCashReceipt.model.Product;
import com.clevertec.generationCashReceipt.repository.ProductRepository;
import com.clevertec.generationCashReceipt.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementation of the logic of the entity Product
 * for working with the database
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */


@Component("ProductService")
public class ProductService implements AbstractService<Product, Long> {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        productRepository.findById(product.getId()).orElseThrow(ProductNotFoundException::new);
        return  productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}

