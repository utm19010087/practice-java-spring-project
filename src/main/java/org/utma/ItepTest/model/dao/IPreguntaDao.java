package org.utma.ItepTest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.utma.ItepTest.model.entity.Pregunta;

public interface IPreguntaDao extends JpaRepository<Pregunta, Long>
{
}
