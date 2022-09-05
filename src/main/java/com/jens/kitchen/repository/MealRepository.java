package com.jens.kitchen.repository;

import com.jens.kitchen.model.dtos.MealDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends MongoRepository<MealDto, String> {

}
