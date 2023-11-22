package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.utma.ItepTest.model.entity.Pregunta;
/**
 * Interfaz que extiende JpaRepository para la entidad Pregunta.
 * Proporciona métodos CRUD estándar y otras operaciones de base de datos para la entidad Pregunta.
 *
 * @see JpaRepository
 * @see Pregunta
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/21
 */
public interface IPreguntaDao extends JpaRepository<Pregunta, Long>
{
    // No es necesario agregar métodos adicionales aquí, ya que JpaRepository proporciona los métodos CRUD estándar.
    // Si necesitas personalizar consultas, puedes agregar métodos en esta interfaz y Spring Data JPA los implementará automáticamente.
}
