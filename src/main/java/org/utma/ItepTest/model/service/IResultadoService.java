package org.utma.ItepTest.model.service;

import org.utma.ItepTest.model.entity.Resultado;
import org.utma.ItepTest.model.service.dto.RespuestaDto;

import java.util.List;

public interface IResultadoService extends IService<Resultado>
{
    public void saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(RespuestaDto respuestaDto);
    public List<Resultado> findResultadoByUsuarioId(Long id);
    public void deleteResultadoByUsuarioId(Long id);
}
