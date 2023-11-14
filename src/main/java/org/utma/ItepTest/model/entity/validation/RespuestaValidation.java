package org.utma.ItepTest.model.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.utma.ItepTest.model.entity.Respuesta;

@Component
public class RespuestaValidation implements Validator
{
    @Override
    public boolean supports(Class<?> clazz) {
        return Respuesta.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"texto","NotEmpty.preguntaRespuesta.texto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"isCorrect","NotNull.preguntaRespuesta.isCorrect");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"idPreguntas","NotNull.preguntaRespuesta.idPreguntas");
    }
}
