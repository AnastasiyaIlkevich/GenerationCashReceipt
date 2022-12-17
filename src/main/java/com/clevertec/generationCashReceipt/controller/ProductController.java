package com.clevertec.generationCashReceipt.controller;


import com.clevertec.generationCashReceipt.dto.ProductUpdateDto;
import com.clevertec.generationCashReceipt.model.Product;
import com.clevertec.generationCashReceipt.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for entity Product (CRUD)
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    private final AbstractService abstractService;

    @Autowired
    public ProductController(@Qualifier("ProductService")AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping
    private List<Product> getAllProduct() {
        return abstractService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return (Product) abstractService.findById(id);
    }

    @PostMapping()
    public void saveProduct(@RequestBody ProductUpdateDto productDto) {
        Product product = productDto.toProduct();
        abstractService.save(product);
    }

    @PutMapping("/{id}")
    public ProductUpdateDto updateUser(@PathVariable("id") Long id, @RequestBody ProductUpdateDto productDto) {
        productDto.setId(id);
        Product product = productDto.toProduct();
        return  productDto.fromProduct((Product) abstractService.update(product));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        abstractService.deleteById(id);
    }
}
