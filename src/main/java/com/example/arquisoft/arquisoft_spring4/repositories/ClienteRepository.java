package com.example.arquisoft.arquisoft_spring4.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.arquisoft.arquisoft_spring4.models.ClienteModel;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<ClienteModel, String> {
    Optional<ClienteModel> findByDNI(String dni);
}
