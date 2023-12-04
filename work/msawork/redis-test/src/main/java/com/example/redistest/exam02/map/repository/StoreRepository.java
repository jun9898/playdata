package com.example.redistest.exam02.map.repository;

import com.example.redistest.exam02.map.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity,Long> {
}
