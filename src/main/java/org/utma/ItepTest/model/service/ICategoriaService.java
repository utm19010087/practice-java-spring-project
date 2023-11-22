package org.utma.ItepTest.model.service;

import org.utma.ItepTest.model.entity.Categoria;
/**
 * Interfaz de servicio para la entidad Categoria.
 * Extiende la interfaz IService proporcionando métodos específicos para la entidad Categoria.
 *
 * @see IService
 * @see Categoria
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/21
 */
public interface ICategoriaService extends IService<Categoria>
{
    // No es necesario agregar métodos adicionales aquí, ya que la interfaz padre IService proporciona los métodos estándar CRUD.
}
