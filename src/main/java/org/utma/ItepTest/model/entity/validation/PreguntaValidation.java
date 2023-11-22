package org.utma.ItepTest.model.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.utma.ItepTest.model.entity.Pregunta;

/**
 * La clase PreguntaValidation implementa la interfaz Validator y realiza la validación de la clase Pregunta.
 *
 * <p>
 * Esta clase utiliza las capacidades de validación proporcionadas por el framework Spring. Es un componente de Spring y se puede
 * utilizar para validar instancias de la clase Pregunta o sus subclases.
 * </p>
 *
 * <p>
 * La validación se centra en los campos "texto", "nivel" e "idCategorias". Verifica que "texto" y "nivel" no estén vacíos o compuestos
 * solo por espacios en blanco. Además, verifica que "idCategorias" no sea nulo. Si se encuentran errores de validación, se registran
 * en el objeto Errors proporcionado con los códigos "NotEmpty.pregunta.texto", "NotEmpty.pregunta.nivel" y "NotNull.pregunta.idCategorias"
 * respectivamente.
 * </p>
 *
 * @author Francsico Javier Gnzalez Huerta / Fabrica de software - UTMA
 * @version 0.1 2023/11/22
 */


@Component
public class PreguntaValidation implements Validator
{

    /**
     * Determina si el validador puede manejar la validación para el tipo de clase especificado.
     *
     * @param clazz El tipo de clase a ser validado.
     * @return true si el validador puede manejar la validación para la clase, false de lo contrario.
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Pregunta.class.isAssignableFrom(clazz);
    }


    /**
     * Realiza la validación del objeto target, que debe ser una instancia de la clase Pregunta.
     *
     * <p>
     * Verifica que los campos "texto" y "nivel" no estén vacíos o compuestos solo por espacios en blanco.
     * Además, verifica que "idCategorias" no sea nulo. Si se encuentran errores, se registran en el objeto Errors proporcionado
     * con los códigos "NotEmpty.pregunta.texto", "NotEmpty.pregunta.nivel" y "NotNull.pregunta.idCategorias" respectivamente.
     * </p>
     *
     * @param target El objeto a ser validado.
     * @param errors Contiene los errores de validación encontrados.
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"texto","NotEmpty.pregunta.texto");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nivel","NotEmpty.pregunta.nivel");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"idCategorias","NotNull.pregunta.idCategorias");
    }
}
