package com.jens.kitchen.service.implementation;

import com.jens.kitchen.domain.MealRequest;
import com.jens.kitchen.domain.MealResponse;
import com.jens.kitchen.exceptions.ApiError;
import com.jens.kitchen.exceptions.NotFoundException;
import com.jens.kitchen.model.dtos.MealDto;
import com.jens.kitchen.repository.MealRepository;
import com.jens.kitchen.service.MealService;
import com.jens.kitchen.validator.MealValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MealServiceImplementation implements MealService {

    @Autowired
    private MealValidator validator;

    @Autowired
    private MealRepository repository;

    @Override
    public MealResponse createMeal(MealRequest request) {
        validator.validateRequest(request);

        MealDto meal = MealDto.builder().
                time(request.getTime()).
                name(request.getName()).
                ingredients(request.getIngredients()).
                //recipeSteps(request.getRecipeSteps()).
                build();

        MealDto savedMeal = repository.save(meal);

        return new MealResponse(savedMeal.getId());
    }

    @Override
    public List<MealDto> getAllMeals(){
        return repository.findAll();
    }

    @Override
    public MealDto getMealById(String id){
        Optional<MealDto> mealFound = repository.findById(id);

        if(mealFound.isPresent()){
            return mealFound.get();
        }else{
            ApiError error = ApiError.builder().field("Meal").description(String.format("Meal with id '%s' not found.", id)).build();
            throw new NotFoundException("", error);
        }
    }

    @Override
    public MealDto updateMeal(MealRequest request, String id){
        validator.validateRequest(request);

        Optional<MealDto> mealFound = repository.findById(id);

        if(mealFound.isPresent()){
            MealDto updatedMeal = mealFound.get();
            updatedMeal.setId(id).
                    setTime(request.getTime()).
                    setName(request.getName()).
                    setIngredients(request.getIngredients());
                    //setRecipeSteps(request.getRecipeSteps());

            repository.save(updatedMeal);
            return updatedMeal;
        }else{
            ApiError error = ApiError.builder().field("Meal").description(String.format("Meal with id '%s' not found.", id)).build();
            throw new NotFoundException("", error);
        }
    }

    @Override
    public void deleteMeal(String id) {
        Optional<MealDto> mealFound = repository.findById(id);

        if(mealFound.isPresent()){
            repository.deleteById(id);
        }else{
            ApiError error = ApiError.builder().field("Meal").description(String.format("Meal with id '%s' not found.", id)).build();
            throw new NotFoundException("", error);
        }
    }

    @Override
    public List<String> mealsSelector(int number) {
        List<MealDto> mealsCollection  = getAllMeals();
        Set<String> mealsResponse = new HashSet<>();

        while (mealsResponse.size() < number){
            mealsResponse.add(mealsCollection.get((int)(Math.random() * mealsCollection.size())).getName());
        }

        return new ArrayList<>(mealsResponse);
    }
}
