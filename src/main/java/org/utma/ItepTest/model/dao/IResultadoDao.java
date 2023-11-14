package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utma.ItepTest.model.entity.Resultado;

public interface IResultadoDao extends JpaRepository<Resultado, Long>
{
}
