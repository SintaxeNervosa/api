package com.github.sintaxenervosa.discoxp.validations;

import org.springframework.stereotype.Component;

import com.github.sintaxenervosa.discoxp.model.User;
import com.github.sintaxenervosa.discoxp.repository.UserRepository;

@Component
public class LoginValidator implements Validator<User>, EmailValidator{

    private final UserRepository userRepository;

    public LoginValidator(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserRepository getUserRepository(){
        return userRepository;
    }

    @Override
    public void validate(User user) throws IllegalAccessException {
        if (!user.isStatus()) {
            throw new IllegalAccessException("Usuário desativado");
        }
        
        validateEmail(user.getEmail());
        // dps coloco todas
    }
}
