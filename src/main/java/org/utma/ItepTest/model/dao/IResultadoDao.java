package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.utma.ItepTest.model.entity.Resultado;

import java.util.List;

public interface IResultadoDao extends JpaRepository<Resultado, Long>
{
    @Query("SELECT r FROM Resultado r WHERE r.usuario.idUsuarios = ?1")
    public List<Resultado> findResultadoByUsuarioId(Long id);

    @Modifying
    @Query("DELETE FROM Resultado r WHERE r.usuario.idUsuarios = ?1")
    public void deleteResultadoByUsuarioId(Long id);
}
