package com.puente.challenge.repository;

import com.puente.challenge.model.FavoriteSymbolsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavoriteSymbolsRepository extends MongoRepository<FavoriteSymbolsModel, String> {
    Optional<FavoriteSymbolsModel> findByEmail (String email);
}
