package com.traini8.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, Long> {
    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        // Initialization logic if needed
    }

    @Override
    public boolean isValid(Long phone, ConstraintValidatorContext context) {
        // Check if phone number is null
        if (phone == null) {
            return false;
        }
        // Convert phone number to string and check its length
        String phoneStr = String.valueOf(phone);
        return phoneStr.length() == 10; // Phone number must have exactly 10 digits
    }
}
