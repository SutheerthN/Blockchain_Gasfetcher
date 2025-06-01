package com.example.backend.repository;

import com.example.backend.model.GasData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GasDataRepository extends MongoRepository<GasData, String> {}
