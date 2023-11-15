package org.utma.ItepTest.model.service;

import org.utma.ItepTest.model.entity.Resultado;
import org.utma.ItepTest.model.service.dto.RespuestaDto;

public interface IResultadoService extends IService<Resultado>
{
    public void saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(RespuestaDto respuestaDto);
}
