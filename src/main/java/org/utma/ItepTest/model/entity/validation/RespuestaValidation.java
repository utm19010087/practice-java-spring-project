package org.utma.ItepTest.model.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.utma.ItepTest.model.entity.Respuesta;

/**
 * La clase RespuestaValidation implementa la interfaz Validator y realiza la validación de la clase Respuesta.
 *
 * <p>
 * Esta clase utiliza las capacidades de validación proporcionadas por el framework Spring. Es un componente de Spring y se puede
 * utilizar para validar instancias de la clase Respuesta o sus subclases.
 * </p>
 *
 * <p>
 * La validación se centra en los campos "texto", "isCorrect" e "idPreguntas". Verifica que "texto" no esté vacío o compuesto solo por
 * espacios en blanco, "isCorrect" no esté vacío y "idPreguntas" no sea nulo. Si se encuentran errores de validación, se registran
 * en el objeto Errors proporcionado con los códigos "NotEmpty.preguntaRespuesta.texto", "NotNull.preguntaRespuesta.isCorrect" y
 * "NotNull.preguntaRespuesta.idPreguntas" respectivamente.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de software - UTMA
 * @version 0.1, 2023/11/22
 */

@Component
public class RespuestaValidation implements Validator
{

    /**
     * Determina si el validador puede manejar la validación para el tipo de clase especificado.
     *
     * @param clazz El tipo de clase a ser validado.
     * @return true si el validador puede manejar la validación para la clase, false de lo contrario.
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Respuesta.class.isAssignableFrom(clazz);
    }


    /**
     * Realiza la validación del objeto target, que debe ser una instancia de la clase Respuesta.
     *
     * <p>
     * Verifica que los campos "texto", "isCorrect" e "idPreguntas" no estén vacíos o compuestos solo por espacios en blanco.
     * Además, verifica que "isCorrect" no sea nulo. Si se encuentran errores de validación, se registran en el objeto Errors proporcionado
     * con los códigos "NotEmpty.preguntaRespuesta.texto", "NotNull.preguntaRespuesta.isCorrect" y "NotNull.preguntaRespuesta.idPreguntas"
     * respectivamente.
     * </p>
     *
     * @param target El objeto a ser validado.
     * @param errors Contiene los errores de validación encontrados.
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"texto","NotEmpty.preguntaRespuesta.texto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"isCorrect","NotNull.preguntaRespuesta.isCorrect");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"idPreguntas","NotNull.preguntaRespuesta.idPreguntas");
    }
}
