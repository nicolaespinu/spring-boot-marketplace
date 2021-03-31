package com.spinic.market.repository;

import com.spinic.market.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> , JpaRepository<Product, Long> {
    List<Product> findAllByOwner(String owner, Pageable pageable);
}
