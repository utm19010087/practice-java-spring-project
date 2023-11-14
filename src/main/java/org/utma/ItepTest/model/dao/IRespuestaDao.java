package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.utma.ItepTest.model.entity.Respuesta;

public interface IRespuestaDao extends JpaRepository<Respuesta, Long>
{
}
