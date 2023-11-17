package org.utma.ItepTest.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.utma.ItepTest.model.entity.Pregunta;
import org.utma.ItepTest.model.entity.Resultado;
import org.utma.ItepTest.model.service.dto.RespuestaDto;

import java.util.List;

public interface IResultadoService extends IService<Resultado>
{
    public void saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(RespuestaDto respuestaDto);
    public Page<Resultado> findResultadoByUsuarioId(Long id, Pageable pageable);
    public void deleteResultadoByUsuarioId(Long id);

}
