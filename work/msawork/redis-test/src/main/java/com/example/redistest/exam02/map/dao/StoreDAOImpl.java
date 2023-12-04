package com.example.redistest.exam02.map.dao;

import com.example.redistest.exam02.map.entity.StoreEntity;
import com.example.redistest.exam02.map.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class StoreDAOImpl implements StoreDAO{
    private final StoreRepository repository;
    @Override
    public List<StoreEntity> getStoreList() {
        return repository.findAll();
    }
}
