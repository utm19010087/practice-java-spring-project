package org.utma.ItepTest.model.entity.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.utma.ItepTest.model.entity.Usuario;

/**
 * La clase UsuarioValidation implementa la interfaz Validator y realiza la validación de la clase Usuario.
 *
 * <p>
 * Esta clase utiliza las capacidades de validación proporcionadas por el framework Spring. Es un componente de Spring y se puede
 * utilizar para validar instancias de la clase Usuario o sus subclases.
 * </p>
 *
 * <p>
 * La validación se centra en los campos "email", "matricula" y "contraseña". Verifica que "email" no esté vacío o compuesto solo por
 * espacios en blanco, "matricula" no esté vacía y "contraseña" no esté vacía. Además, se realiza una validación de patrón en el campo
 * "matricula", aunque la anotación mencionada en el código es "Pattern.usuario.matricula", el método ValidationUtils.rejectIfEmptyOrWhitespace
 * no valida patrones, sería necesario utilizar un método diferente para aplicar la validación de patrón.
 * </p>
 *
 * <p>
 * Si se encuentran errores de validación, se registran en el objeto Errors proporcionado con los códigos "Email.usuario.email",
 * "NotEmpty.usuario.matricula", "NotEmpty.usuario.contraseña" y "Pattern.usuario.matricula" respectivamente.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de software - UTMA
 * @version 0.1, 2023/11/22
 */

@Component
public class UsuarioValidation implements Validator
{

    /**
     * Determina si el validador puede manejar la validación para el tipo de clase especificado.
     *
     * @param clazz El tipo de clase a ser validado.
     * @return true si el validador puede manejar la validación para la clase, false de lo contrario.
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    /**
     * Realiza la validación del objeto target, que debe ser una instancia de la clase Usuario.
     *
     * <p>
     * Verifica que los campos "email", "matricula" y "contraseña" no estén vacíos o compuestos solo por espacios en blanco.
     * Además, realiza una validación de patrón en el campo "matricula", aunque el método ValidationUtils.rejectIfEmptyOrWhitespace
     * no realiza directamente validación de patrón, sino que se utiliza el código "Pattern.usuario.matricula" como identificador.
     * </p>
     *
     * <p>
     * Si se encuentran errores de validación, se registran en el objeto Errors proporcionado con los códigos "Email.usuario.email",
     * "NotEmpty.usuario.matricula", "NotEmpty.usuario.contraseña" y "Pattern.usuario.matricula" respectivamente.
     * </p>
     *
     * @param target El objeto a ser validado.
     * @param errors Contiene los errores de validación encontrados.
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","Email.usuario.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"matricula","NotEmpty.usuario.matricula");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"contraseña","NotEmpty.usuario.contraseña");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"matricula","Pattern.usuario.matricula");
    }
}
