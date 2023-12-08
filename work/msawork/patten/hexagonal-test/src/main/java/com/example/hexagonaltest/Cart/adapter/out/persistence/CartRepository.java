package com.example.hexagonaltest.Cart.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findByCartNo(Long cartNo);
}
