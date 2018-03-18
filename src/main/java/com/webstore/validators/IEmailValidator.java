package com.webstore.validators;

import com.sun.deploy.security.ValidationState;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Created by Blazej on 18.03.2018.
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface IEmailValidator {
    String message() default "Adres email jest niepoprawny";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
