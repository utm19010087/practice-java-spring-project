package org.utma.ItepTest.model.service.dto;

import org.utma.ItepTest.model.entity.Respuesta;
/**
 * La clase RespuestaDto representa un objeto de transferencia de datos (DTO) para manejar respuestas en la capa de servicio.
 *
 * <p>
 * Esta clase se utiliza para transferir información entre la capa de controlador y la capa de servicio relacionada con las respuestas.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/22
 */
public class RespuestaDto
{
    /**
     * Arreglo de respuestas seleccionadas.
     */
    private Respuesta[] selector;
    /**
     * Arreglo de índices de preguntas asociadas a las respuestas seleccionadas.
     */
    private int[] preguntaIndex;

    /**
     * Identificador del usuario asociado a las respuestas.
     */
    private Long usuarioId;
    /**
     * Obtiene el arreglo de respuestas seleccionadas.
     *
     * @return El arreglo de respuestas seleccionadas.
     */
    public Respuesta[] getSelector() {
        return selector;
    }
    /**
     * Establece el arreglo de respuestas seleccionadas.
     *
     * @param selector El arreglo de respuestas seleccionadas a establecer.
     */
    public void setSelector(Respuesta[] selector) {
        this.selector = selector;
    }
    /**
     * Obtiene el arreglo de índices de preguntas asociadas a las respuestas seleccionadas.
     *
     * @return El arreglo de índices de preguntas.
     */
    public int[] getPreguntaIndex() {
        return preguntaIndex;
    }
    /**
     * Establece el arreglo de índices de preguntas asociadas a las respuestas seleccionadas.
     *
     * @param preguntaIndex El arreglo de índices de preguntas a establecer.
     */
    public void setPreguntaIndex(int[] preguntaIndex) {
        this.preguntaIndex = preguntaIndex;
    }
    /**
     * Obtiene el identificador del usuario asociado a las respuestas.
     *
     * @return El identificador del usuario.
     */
    public Long getUsuarioId() {
        return usuarioId;
    }
    /**
     * Establece el identificador del usuario asociado a las respuestas.
     *
     * @param usuarioId El identificador del usuario a establecer.
     */
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
