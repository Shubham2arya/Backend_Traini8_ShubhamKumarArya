package com.traini8.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PincodeValidator implements ConstraintValidator<ValidPincode, Long> {

    @Override
    public void initialize(ValidPincode constraintAnnotation) {
        // Initialization logic if needed
    }

    @Override
    public boolean isValid(Long pincode, ConstraintValidatorContext context) {
        // Check if pincode is not null and is a non-negative number
        return pincode != null && pincode >= 0; 
    }
}
