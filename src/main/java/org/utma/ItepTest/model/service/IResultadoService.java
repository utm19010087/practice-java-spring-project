package org.utma.ItepTest.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.utma.ItepTest.model.entity.Pregunta;
import org.utma.ItepTest.model.entity.Resultado;
import org.utma.ItepTest.model.service.dto.RespuestaDto;

import java.util.List;
/**
 * Interfaz que define las operaciones de servicio para la entidad Resultado.
 *
 * <p>
 * Esta interfaz extiende la interfaz IService y proporciona métodos específicos para la entidad Resultado.
 * Incluye operaciones para guardar resultados con información relacionada a usuario, pregunta y respuesta,
 * así como operaciones para buscar resultados por usuario, eliminar resultados por usuario y buscar la cantidad
 * de respuestas correctas para un usuario.
 * </p>
 *
 * @see IService
 * @see Resultado
 * @see RespuestaDto
 * @see Page
 * @see Pageable
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/22
 */
public interface IResultadoService extends IService<Resultado>
{
    /**
     * Guarda resultados asociados a un usuario, pregunta y respuesta.
     *
     * @param respuestaDto El objeto DTO que contiene información sobre las respuestas, preguntas y usuarios.
     */
    public void saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(RespuestaDto respuestaDto);
    /**
     * Elimina resultados por el identificador de usuario.
     *
     * @param id El identificador del usuario.
     */
    public Page<Resultado> findResultadoByUsuarioId(Long id, Pageable pageable);
    /**
     * Elimina resultados por el identificador de usuario.
     *
     * @param id El identificador del usuario.
     */
    public void deleteResultadoByUsuarioId(Long id);
    /**
     * Busca la cantidad de resultados correctos por el identificador de usuario.
     *
     * @param id El identificador del usuario.
     * @return La cantidad de respuestas correctas del usuario.
     */
    public int findResultadoByUsuarioIdWhereIsCorrect(Long id);
}
