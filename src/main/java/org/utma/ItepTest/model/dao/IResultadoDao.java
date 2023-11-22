package org.utma.ItepTest.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.utma.ItepTest.model.entity.Pregunta;
import org.utma.ItepTest.model.entity.Resultado;

import java.util.List;
/**
 * Interfaz que extiende JpaRepository para la entidad Resultado.
 * Proporciona métodos CRUD estándar y otras operaciones de base de datos para la entidad Resultado.
 *
 * @see JpaRepository
 * @see Resultado
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/21
 */
public interface IResultadoDao extends JpaRepository<Resultado, Long>
{
    // No es necesario agregar métodos adicionales aquí, ya que JpaRepository proporciona los métodos CRUD estándar.
    // Si necesitas personalizar consultas, puedes agregar métodos en esta interfaz y Spring Data JPA los implementará automáticamente.
    /**
     * Encuentra los resultados paginados por ID de usuario.
     *
     * @param id       El ID del usuario.
     * @param pageable Configuración de paginación.
     * @return Una página de resultados asociados al usuario.
     */
    @Query("SELECT r FROM Resultado r WHERE r.usuario.idUsuarios = ?1")
    public Page<Resultado> findResultadoByUsuarioId(Long id, Pageable pageable);
    /**
     * Elimina los resultados por ID de usuario.
     *
     * @param id El ID del usuario cuyos resultados deben eliminarse.
     */
    @Modifying
    @Query("DELETE FROM Resultado r WHERE r.usuario.idUsuarios = ?1")
    public void deleteResultadoByUsuarioId(Long id);
    /**
     * Cuenta el número de resultados donde la respuesta es correcta por ID de usuario.
     *
     * @param id El ID del usuario.
     * @return El número de resultados con respuestas correctas asociadas al usuario.
     */
    @Query("SELECT COUNT(*) FROM Resultado r WHERE r.usuario.idUsuarios = ?1 and r.respuesta.isCorrect = true")
    public int findResultadoByUsuarioWhereRespuestaIsCorrect(Long id);
}