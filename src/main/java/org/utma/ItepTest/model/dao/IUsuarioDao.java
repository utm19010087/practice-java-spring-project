package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.utma.ItepTest.model.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>
{
    @Query("SELECT u FROM Usuario u WHERE u.matricula = ?1")
    public Usuario findUsuarioByMatricula(String matricula);
}
