package com.jens.kitchen.service.implementation;

import com.jens.kitchen.domain.NewMealRequest;
import com.jens.kitchen.domain.NewMealResponse;
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
    public NewMealResponse createMeal(NewMealRequest request) {
        //validator.validate(request);

        MealDto meal = MealDto.builder().
                mealName(request.getMealName()).
                mealType(request.getMealType()).
                ingredients(request.getIngredients()).
                recipe(request.getRecipe()).
                build();

        MealDto savedMeal = repository.save(meal);

        return new NewMealResponse(savedMeal.getId());
    }

    @Override
    public List<MealDto> getAllMeals(){
        return repository.findAll();
    }

    @Override
    public MealDto getMealById(String id){
        Optional<MealDto> mealFound = repository.findById(id);

        if(mealFound.isPresent()){
            MealDto meal = mealFound.get();
            return meal;
        }else{
            throw new NotFoundException(String.format("Meal not found with id: ", id));
        }
    }

    @Override
    public MealDto updateMeal(MealDto request, String id){
        validator.validate(request);

        Optional<MealDto> mealFound = repository.findById(id);

        if(mealFound.isPresent()){
            MealDto updatedMeal = mealFound.get();
            updatedMeal.setMealName(request.getMealName()).
                    setMealType(request.getMealType()).
                    setIngredients(request.getIngredients()).
                    setRecipe(request.getRecipe());

            repository.save(updatedMeal);
            return updatedMeal;
        }else{
            throw new NotFoundException(String.format("Meal not found with id: ", id));
        }
    }

    @Override
    public void deleteMeal(String id) {
        Optional<MealDto> mealFound = repository.findById(id);

        if(mealFound.isPresent()){
            repository.deleteById(id);
        }else{
            throw new NotFoundException(String.format("Meal not found with id: ", id));
        }
    }

    @Override
    public List<String> mealsSelector(int number) {
        List<MealDto> mealsCollection  = getAllMeals();
        Set<String> mealsResponse = new HashSet<>();

        while (mealsResponse.size() < number){
            mealsResponse.add(mealsCollection.get((int)(Math.random() * mealsCollection.size())).getMealName());
        }

        return new ArrayList<>(mealsResponse);
    }
}
