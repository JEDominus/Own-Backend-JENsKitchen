package com.jens.kitchen.repository;

import com.jens.kitchen.model.dtos.MealDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends MongoRepository<MealDto, String> {

    @Override
    List<MealDto> findAll();


    @Query("{'time' : ?0}")
    List<MealDto> findByTime(String time);
}
