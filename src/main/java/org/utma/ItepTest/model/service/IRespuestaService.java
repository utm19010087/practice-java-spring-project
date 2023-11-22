package org.utma.ItepTest.model.service;

import org.utma.ItepTest.model.entity.Respuesta;
import org.utma.ItepTest.model.service.dto.RespuestaDto;
/**
 * Interfaz que define las operaciones de servicio para la entidad Respuesta.
 *
 * <p>
 * Esta interfaz extiende la interfaz IService y proporciona métodos específicos para la entidad Respuesta.
 * No incluye métodos adicionales en este momento, pero puede extenderse en el futuro para agregar operaciones
 * específicas relacionadas con Respuesta.
 * </p>
 *
 * @see IService
 * @see Respuesta
 * @see RespuestaDto
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/21
 */
public interface IRespuestaService extends IService<Respuesta>
{
    // No es necesario agregar métodos adicionales aquí, ya que la interfaz padre IService proporciona los métodos estándar CRUD.
}
