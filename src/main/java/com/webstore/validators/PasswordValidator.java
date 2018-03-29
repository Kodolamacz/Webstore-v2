package com.webstore.validators;

import com.webstore.domain.User;
import com.webstore.validators.interfaces.MatchingPassword;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Blazej on 24.03.2018.
 */
@Component
public class PasswordValidator implements ConstraintValidator<MatchingPassword, Object> {

    @Override
    public void initialize(MatchingPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        User user = (User) o;
        return user.getPassword().equals(user.getMatchingPassword());

    }
}
