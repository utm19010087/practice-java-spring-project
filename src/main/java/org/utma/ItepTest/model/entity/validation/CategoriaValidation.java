package org.utma.ItepTest.model.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.utma.ItepTest.model.entity.Categoria;

@Component
public class CategoriaValidation implements Validator
{
    @Override
    public boolean supports(Class<?> clazz) {
        return Categoria.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotEmpty.categoria.nombre");
    }
}
