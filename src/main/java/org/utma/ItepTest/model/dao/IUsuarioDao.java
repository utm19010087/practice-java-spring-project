package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utma.ItepTest.model.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>
{
}
