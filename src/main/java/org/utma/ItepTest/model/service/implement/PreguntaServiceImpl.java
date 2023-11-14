package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.IPreguntaDao;
import org.utma.ItepTest.model.entity.Pregunta;
import org.utma.ItepTest.model.service.IPreguntaService;

import java.util.List;

@Service
public class PreguntaServiceImpl implements IPreguntaService
{
    @Autowired
    private IPreguntaDao preguntaDao;
    @Override
    @Transactional
    public void save(Pregunta pregunta) {
        preguntaDao.save(pregunta);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id>0)
        {
            preguntaDao.deleteById(id);
        }
    }

    @Override
    @Transactional
    public Pregunta findById(Long id) {
        return preguntaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Pregunta> findAll() {
        return List.copyOf(preguntaDao.findAll());
    }
}
