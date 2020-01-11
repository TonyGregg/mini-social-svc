package com.genil.learning.minisocialsvc.tms.adapter.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * Created by Antony Genil Gregory on 1/11/2020 2:07 PM
 * For project : mini-social-svc
 **/
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = InvoiceValidator.class)
public @interface Invoice {
    String message() default "Invalid Invoice #. It should start with IN";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
