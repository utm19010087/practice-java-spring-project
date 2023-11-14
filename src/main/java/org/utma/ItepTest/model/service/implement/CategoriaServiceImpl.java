package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.ICategoriaDao;
import org.utma.ItepTest.model.entity.Categoria;
import org.utma.ItepTest.model.service.ICategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService
{
    @Autowired
    private ICategoriaDao categoriaDao;
    @Override
    @Transactional
    public void save(Categoria categoria)
    {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void deleteById(Long id)
    {
        if (id>0)
        {
            categoriaDao.deleteById(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Long id)
    {
        return categoriaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll()
    {
        return List.copyOf(categoriaDao.findAll());
    }
}
