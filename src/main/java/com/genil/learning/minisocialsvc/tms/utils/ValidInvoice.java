package com.genil.learning.minisocialsvc.tms.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Antony Genil on 1/8/20 at 18 38 for JavaExperiments
 **/
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = InvoiceValidator.class)
public @interface ValidInvoice {
    String message() default "incorrect invoice value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
