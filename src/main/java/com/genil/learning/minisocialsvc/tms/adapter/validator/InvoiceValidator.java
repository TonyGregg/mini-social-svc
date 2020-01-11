package com.genil.learning.minisocialsvc.tms.adapter.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Antony Genil Gregory on 1/11/2020 2:08 PM
 * For project : mini-social-svc
 **/
public class InvoiceValidator implements ConstraintValidator<Invoice, String> {
    @Override
    public void initialize(Invoice constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
