package org.utma.ItepTest.model.service;

import java.util.List;
/**
 * Interfaz genérica de servicio que proporciona operaciones CRUD estándar para entidades.
 *
 * @param <T> Tipo de la entidad.
 * @see T
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/21
 */
public interface IService <T>
{
    /**
     * Guarda una entidad en la base de datos.
     *
     * @param t La entidad a guardar.
     */
    public void save(T t);
    /**
     /**
     * Elimina una entidad por su ID.
     *
     * @param id El ID de la entidad a eliminar.
     */
    public void deleteById(Long id);
    /**
     * Encuentra una entidad por su ID.
     *
     * @param id El ID de la entidad a buscar.
     * @return La entidad encontrada o null si no se encuentra.
     */
    public T findById(Long id);
    /**
     * Obtiene todas las entidades de la base de datos.
     *
     * @return Una lista de todas las entidades.
     */
    public List<T> findAll();
}
