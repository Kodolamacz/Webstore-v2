package com.webstore.validators;

import com.webstore.domain.User;
import com.webstore.services.UserService;
import com.webstore.validators.interfaces.UserExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by Blazej on 24.03.2018.
 */
@Component
public class UserExistsValidator implements ConstraintValidator<UserExists,Object>{

   // private static final Logger log = Logger.getLogger(UserExistsValidator.class);
    @Autowired
    private UserService userService;

    @Override
    public void initialize(UserExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
      User user = (User)o;
        List<String> logins = userService.findLogins();
        return !logins.contains(user.getLogin());
    }
}
