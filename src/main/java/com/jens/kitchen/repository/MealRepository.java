package com.jens.kitchen.repository;

import com.jens.kitchen.model.dtos.MealDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends MongoRepository<MealDto, String> {

    List<MealDto> findAll();

}
