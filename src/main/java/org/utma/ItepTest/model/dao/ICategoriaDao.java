package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utma.ItepTest.model.entity.Categoria;

public interface ICategoriaDao extends JpaRepository<Categoria, Long>
{
}
