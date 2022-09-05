package com.jens.kitchen.validator;

import com.jens.kitchen.exceptions.BadRequestException;
import com.jens.kitchen.model.dtos.StepDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepValidator {

    private static final String WRONG_FIELD = "Field %s is empty.";
    private static final String WRONG_LIST = "Steps list is empty.";
    private static final String DESCRIPTION = "'Description'";

    public void validate(List<StepDto> steps){
        validateList(steps);

        for(StepDto step : steps){
            validateDescription(step.getDescription());
        }
    }

    private void validateList(List<StepDto> steps){
        if(steps.size() == 0 || steps == null){
            throw new BadRequestException(String.format(WRONG_LIST));
        }
    }

    private void validateDescription(String description){
        if(description.isBlank() || description.isEmpty()){
            throw new BadRequestException(String.format(WRONG_FIELD, DESCRIPTION));
        }
    }

}
