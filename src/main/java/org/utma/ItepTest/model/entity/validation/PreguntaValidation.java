package org.utma.ItepTest.model.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.utma.ItepTest.model.entity.Pregunta;

@Component
public class PreguntaValidation implements Validator
{
    @Override
    public boolean supports(Class<?> clazz) {
        return Pregunta.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"texto","NotEmpty.pregunta.texto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nivel","NotEmpty.pregunta.nivel");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"idCategorias","NotNull.pregunta.idCategorias");
    }
}
