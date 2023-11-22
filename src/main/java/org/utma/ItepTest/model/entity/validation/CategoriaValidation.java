package org.utma.ItepTest.model.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.utma.ItepTest.model.entity.Categoria;

/**
 * La clase CategoriaValidation implementa la interfaz Validator y realiza la validación del campo nombre para la clase Categoria.
 *
 * <p>
 * Esta clase utiliza las capacidades de validación proporcionadas por el framework Spring. Es un componente de Spring y se puede
 * utilizar para validar instancias de la clase Categoria o sus subclases.
 * </p>
 *
 * <p>
 * La validación se centra en el campo "nombre" y verifica que no esté vacío o compuesto solo por espacios en blanco.
 * Si se encuentra un error de validación, se registra en el objeto Errors proporcionado.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de software - UTMA
 * @version 0.1, 2023/11/22
 */

@Component
public class CategoriaValidation implements Validator
{
    /**
     * Determina si el validador puede manejar la validación para el tipo de clase especificado.
     *
     * @param clazz El tipo de clase a ser validado.
     * @return true si el validador puede manejar la validación para la clase, false de lo contrario.
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Categoria.class.isAssignableFrom(clazz);
    }

    /**
     * Realiza la validación del objeto target, que debe ser una instancia de la clase Categoria.
     *
     * <p>
     * Verifica que el campo "nombre" no esté vacío o compuesto solo por espacios en blanco.
     * Si se encuentra un error, se registra en el objeto Errors proporcionado con el código "NotEmpty.categoria.nombre".
     * </p>
     *
     * @param target El objeto a ser validado.
     * @param errors Contiene los errores de validación encontrados.
     */

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotEmpty.categoria.nombre");
    }
}
