package com.genil.learning.minisocialsvc.tms.utils;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Antony Genil on 1/8/20 at 19 10 for JavaExperiments
 **/
public class InvoiceValidator implements ConstraintValidator<ValidInvoice, String > {
    @Override
    public void initialize(ValidInvoice constraintAnnotation) {

    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(input)) return false;
        if (input.startsWith("IN")) return true;
        return false;
    }
}
