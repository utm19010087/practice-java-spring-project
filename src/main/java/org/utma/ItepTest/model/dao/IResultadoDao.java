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

public interface IResultadoDao extends JpaRepository<Resultado, Long> {
    @Query("SELECT r FROM Resultado r WHERE r.usuario.idUsuarios = ?1")
    public Page<Resultado> findResultadoByUsuarioId(Long id, Pageable pageable);

    @Modifying
    @Query("DELETE FROM Resultado r WHERE r.usuario.idUsuarios = ?1")
    public void deleteResultadoByUsuarioId(Long id);
}