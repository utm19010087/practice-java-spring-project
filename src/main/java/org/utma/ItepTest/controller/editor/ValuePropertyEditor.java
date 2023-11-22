package org.utma.ItepTest.controller.editor;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * ValuePropertyEditor representa un editor que nos permitira convertir los ingresados textos en LowerCase.
 * ValuePropertyEditor hereda de PropertyEditorSupport y sobre escribe el metodo setAsText que recibe como parametro
 * un tipo String, este string sera convertido en LowerCase y se eliminaran sus espacios por medio
 * de la funcion setValue.
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/21
 */
@Component
public class ValuePropertyEditor extends PropertyEditorSupport
{
    /**
     * Permite la conversion de textos en LowerCase.
     * Recibe un String como parametro unico y se auxilia de el metodo setValue. Enviamos el parametro String con
     * .toLowerCase() para convertir a minusculas y .trim() para eliminar los espacios.
     * @param text  The string to be parsed.
     * @throws IllegalArgumentException El codigo no tiene el formato deseado.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toLowerCase().trim());
    }
}
