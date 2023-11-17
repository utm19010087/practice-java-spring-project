package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.IResultadoDao;
import org.utma.ItepTest.model.entity.Pregunta;
import org.utma.ItepTest.model.entity.Respuesta;
import org.utma.ItepTest.model.entity.Resultado;
import org.utma.ItepTest.model.service.IPreguntaService;
import org.utma.ItepTest.model.service.IResultadoService;
import org.utma.ItepTest.model.service.IUsuarioService;
import org.utma.ItepTest.model.service.dto.RespuestaDto;

import java.util.Date;
import java.util.List;

@Service
public class ResultadoServiceImpl implements IResultadoService
{
    @Autowired
    private IResultadoDao resultadoDao;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPreguntaService preguntaService;

    @Override
    @Transactional
    public void save(Resultado resultado)
    {
        if (resultado != null)
        {
            resultadoDao.save(resultado);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id)
    {
        if (id > 0)
        {
            resultadoDao.deleteById(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Resultado findById(Long id)
    {
        return resultadoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Resultado> findAll()
    {
        return List.copyOf(resultadoDao.findAll());
    }

    @Override
    @Transactional
    public void saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(RespuestaDto respuestaDto)
    {
        Respuesta[] respuestas = respuestaDto.getSelector();
        int[] preguntaIds = respuestaDto.getPreguntaIndex();
        Long usuarioId = respuestaDto.getUsuarioId();

        for (int i=0; i<respuestas.length; i++)
        {
            Respuesta respuesta = respuestas[i];
            if (respuesta != null && preguntaIds[i] > 0)
            {
                Resultado resultado = new Resultado();
                resultado.setUsuario(usuarioService.findById(usuarioId));
                resultado.setPregunta(preguntaService.findById((long) preguntaIds[i]));
                resultado.setRespuesta(respuesta);
                resultado.setCreateAt(new Date());
                save(resultado);
            }
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Resultado> findResultadoByUsuarioId(Long id, Pageable pageable) {
        return resultadoDao.findResultadoByUsuarioId(id, pageable);
    }

    @Override
    @Transactional
    public void deleteResultadoByUsuarioId(Long id) {
        resultadoDao.deleteResultadoByUsuarioId(id);
    }

}
