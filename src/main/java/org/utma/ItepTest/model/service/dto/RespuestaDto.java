package org.utma.ItepTest.model.service.dto;

import org.utma.ItepTest.model.entity.Respuesta;

public class RespuestaDto
{
    private Respuesta[] selector;
    private int[] preguntaIndex;

    public Respuesta[] getSelector() {
        return selector;
    }

    public void setSelector(Respuesta[] selector) {
        this.selector = selector;
    }

    public int[] getPreguntaIndex() {
        return preguntaIndex;
    }

    public void setPreguntaIndex(int[] preguntaIndex) {
        this.preguntaIndex = preguntaIndex;
    }
}
