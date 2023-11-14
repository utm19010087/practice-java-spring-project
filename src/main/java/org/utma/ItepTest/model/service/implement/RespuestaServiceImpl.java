package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.IRespuestaDao;
import org.utma.ItepTest.model.entity.Respuesta;
import org.utma.ItepTest.model.service.IPreguntaService;
import org.utma.ItepTest.model.service.IRespuestaService;
import org.utma.ItepTest.model.service.IUsuarioService;

import java.util.List;

@Service
public class RespuestaServiceImpl implements IRespuestaService
{
    @Autowired
    private IRespuestaDao respuestaDao;

    @Override
    @Transactional
    public void save(Respuesta respuesta) {
        respuestaDao.save(respuesta);
    }

    @Override
    @Transactional
    public void deleteById(Long id)
    {
        if (id>0)
        {
            respuestaDao.deleteById(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Respuesta findById(Long id) {
        return respuestaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Respuesta> findAll() {
        return List.copyOf(respuestaDao.findAll());
    }
}
