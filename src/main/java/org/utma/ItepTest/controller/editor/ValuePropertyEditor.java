package org.utma.ItepTest.controller.editor;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class ValuePropertyEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toLowerCase().trim());
    }
}
