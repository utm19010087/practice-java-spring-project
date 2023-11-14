package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.IRespuestaDao;
import org.utma.ItepTest.model.entity.Respuesta;
import org.utma.ItepTest.model.service.IRespuestaService;

import java.util.List;

@Service
public class RespuestaImpl implements IRespuestaService
{
    @Autowired
    private IRespuestaDao preguntaRespuestaDao;
    @Override
    @Transactional
    public void save(Respuesta preguntaRespuesta) {
        preguntaRespuestaDao.save(preguntaRespuesta);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id>0)
        {
            preguntaRespuestaDao.deleteById(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Respuesta findById(Long id) {
        return preguntaRespuestaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Respuesta> findAll() {
        return List.copyOf(preguntaRespuestaDao.findAll());
    }
}
