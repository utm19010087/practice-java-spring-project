package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.utma.ItepTest.model.entity.Usuario;
/**
 * Interfaz que extiende JpaRepository para la entidad Usuario.
 * Proporciona métodos CRUD estándar y otras operaciones de base de datos para la entidad Usuario.
 *
 * @see JpaRepository
 * @see Usuario
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/21
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Long>
{
    // No es necesario agregar métodos adicionales aquí, ya que JpaRepository proporciona los métodos CRUD estándar.
    // Si necesitas personalizar consultas, puedes agregar métodos en esta interfaz y Spring Data JPA los implementará automáticamente.
    /**
     * Encuentra un usuario por matrícula.
     *
     * @param matricula La matrícula del usuario a buscar.
     * @return El usuario asociado a la matrícula especificada.
     */
    @Query("SELECT u FROM Usuario u WHERE u.matricula = ?1")
    public Usuario findUsuarioByMatricula(String matricula);
}
