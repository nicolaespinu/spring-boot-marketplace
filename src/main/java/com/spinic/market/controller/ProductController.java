package com.spinic.market.controller;

import com.spinic.market.entities.Product;
import com.spinic.market.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/market/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping
    public Product createProduct(Authentication a, @RequestBody Product product) {
        product.setOwner(a.getName());
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProductById(Authentication a, @PathVariable(value = "id") Long productId,
                                                   @RequestBody Product productForUpdate) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found for this ID:= " + productId));
        if (a.getName().equals(product.getOwner())) {
            product.setId(productForUpdate.getId());
            product.setTitle(productForUpdate.getTitle());
            product.setDescription(productForUpdate.getDescription());
            product.setPrice(productForUpdate.getPrice());
            final Product finalProduct = productRepository.save(product);
            return ResponseEntity.ok(finalProduct);
        } else {
            return ResponseEntity.status(403).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProductById(Authentication a, @PathVariable(value = "id") Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found for this ID:= " + productId));
        Map<String, Boolean> mapResponse = new HashMap<>();
        if (a.getName().equals(product.getOwner())) {
            productRepository.delete(product);
            mapResponse.put("DELETED", Boolean.TRUE);
        } else {
            mapResponse.put("You don't have enough ACCESS", Boolean.FALSE);
        }
        return mapResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> viewProductById(@PathVariable(value = "id") Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found for this ID:= " + productId));
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/my-all")
    public List<Product> listMyProducts(Authentication a) {
        String name = a.getName();
        List<Product> productListByOwner = new ArrayList<>();
        for (var item : productRepository.findAll()) {
            if (item.getOwner().equals(name)) {
                productListByOwner.add(item);
            }
        }
        return productListByOwner;
    }

    @PostMapping("/paginated")
    public ResponseEntity<Page> listAllProductsPaginated(Pageable pageable) {
        return new ResponseEntity<>(productRepository.findAll(pageable), HttpStatus.OK);
    }
}
