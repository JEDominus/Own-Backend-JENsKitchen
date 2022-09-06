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

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImplementation implements MealService {

    @Autowired
    private MealValidator validator;

    @Autowired
    private MealRepository repository;

    @Override
    public NewMealResponse createMeal(NewMealRequest request) {
        validator.validate(request);

        com.jens.kitchen.model.dtos.MealDto meal = com.jens.kitchen.model.dtos.MealDto.builder().
                mealName(request.getMealName()).
                mealType(request.getMealType()).
                ingredients(request.getIngredients()).
                recipe(request.getRecipe()).
                build();

        com.jens.kitchen.model.dtos.MealDto savedMeal = repository.save(meal);

        return new NewMealResponse(savedMeal.getId());
    }

    @Override
    public List<com.jens.kitchen.model.dtos.MealDto> getAllMeals(){
        return repository.findAll();
    }

    @Override
    public com.jens.kitchen.model.dtos.MealDto getMealById(String id){
        Optional<com.jens.kitchen.model.dtos.MealDto> mealFound = repository.findById(id);

        if(mealFound.isPresent()){
            com.jens.kitchen.model.dtos.MealDto meal = mealFound.get();
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
}
