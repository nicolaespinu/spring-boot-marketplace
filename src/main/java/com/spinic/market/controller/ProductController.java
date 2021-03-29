package com.spinic.market.controller;

import com.spinic.market.entities.Product;
import com.spinic.market.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/market/products")
@RequiredArgsConstructor
public class ProductController {
    final private ProductRepository productRepository;


    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws NoSuchElementException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found for this ID:= " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
                                                 @RequestBody Product productForUpdate) throws NoSuchElementException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found for this ID:= " + productId));

        product.setId(productForUpdate.getId());
        product.setTitle(product.getTitle());
        product.setDescription(productForUpdate.getDescription());
        product.setPrice(productForUpdate.getPrice());
        final Product finalProduct = productRepository.save(product);
        return ResponseEntity.ok(finalProduct);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId) throws NoSuchElementException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found for this ID:= " + productId));
        productRepository.delete(product);
        Map<String, Boolean> mapResponse = new HashMap<>();
        mapResponse.put("Deleted", Boolean.TRUE);
        return mapResponse;
    }
}
