package com.btb.securityservice.common.validation.validators;

import com.btb.securityservice.common.validation.annotations.NotNullOrEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullOrEmptyValidator implements ConstraintValidator<NotNullOrEmpty, CharSequence> {


    @Override
    public void initialize(NotNullOrEmpty constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CharSequence value,ConstraintValidatorContext context) {
        return value != null && value.length() > 0;
    }
}
