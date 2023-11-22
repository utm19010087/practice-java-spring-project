package org.utma.ItepTest.controller.editor;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * ValuePropertyEditor representa un editor que nos permitira convertir los ingresados textos en LowerCase.
 * ValuePropertyEditor hereda de PropertyEditorSupport y sobre escribe el metodo setAsText que recibe como parametro
 * un tipo String, este string sera convertido en LowerCase y se eliminaran sus espacios por medio
 * de la funcion setValue.
 * @author Francisco Javier Gonzalez Huerta
 * @version 0.1, 2023/11/21
 */
@Component
public class ValuePropertyEditor extends PropertyEditorSupport
{
    /**
     *
     * @param text  The string to be parsed.
     * @throws IllegalArgumentException
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toLowerCase().trim());
    }
}
