package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.IUsuarioDao;
import org.utma.ItepTest.model.entity.Usuario;
import org.utma.ItepTest.model.service.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService
{
    @Autowired
    private IUsuarioDao usuarioDao;
    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id>0)
        {
            usuarioDao.deleteById(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return List.copyOf(usuarioDao.findAll());
    }
}
