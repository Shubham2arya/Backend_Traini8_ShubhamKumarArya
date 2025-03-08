package com.traini8.validation;

import java.lang.annotation.Documented;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PincodeValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPincode {
    String message() default "Invalid pincode";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
