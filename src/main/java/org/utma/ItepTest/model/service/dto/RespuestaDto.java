package org.utma.ItepTest.model.service.dto;

import org.utma.ItepTest.model.entity.Respuesta;

public class RespuestaDto
{
    private Respuesta[] selector;
    private int[] preguntaIndex;

    private Long usuarioId;

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
