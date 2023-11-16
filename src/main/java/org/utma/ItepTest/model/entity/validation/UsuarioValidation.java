package org.utma.ItepTest.model.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.utma.ItepTest.model.entity.Usuario;

@Component
public class UsuarioValidation implements Validator
{
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","Email.usuario.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"matricula","NotEmpty.usuario.matricula");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"contraseña","NotEmpty.usuario.contraseña");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"matricula","Pattern.usuario.matricula");
    }
}
