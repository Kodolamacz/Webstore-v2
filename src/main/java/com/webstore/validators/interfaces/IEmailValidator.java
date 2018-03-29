package com.webstore.validators.interfaces;

//import com.sun.deploy.security.ValidationState;

import com.webstore.validators.CorrectEmail;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Blazej on 18.03.2018.
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CorrectEmail.class)
@Documented
public @interface IEmailValidator {
    String message() default "{email.validator.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
