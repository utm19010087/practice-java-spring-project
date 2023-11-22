package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.IUsuarioDao;
import org.utma.ItepTest.model.entity.Usuario;
import org.utma.ItepTest.model.service.IUsuarioService;

import java.util.List;
/**
 * Implementación de la interfaz IUsuarioService que proporciona operaciones de servicio relacionadas con la entidad Usuario.
 *
 * <p>
 * Esta clase utiliza la anotación `@Service` de Spring para indicar que es un componente de servicio.
 * Proporciona métodos transaccionales para realizar operaciones CRUD en la entidad Usuario, así como operaciones específicas
 * relacionadas con la autenticación de usuarios.
 * </p>
 *
 * @author [Nombre del autor]
 * @version [Versión del software o clase]
 */
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

    @Override
    @Transactional(readOnly = true)
    public Usuario findByMatricula(String matricula) {
        return usuarioDao.findUsuarioByMatricula(matricula);
    }

    @Override
    public boolean loginWithMatriculaWithPassword(String matricula, String password) {
        Usuario usuario;
        if (!matricula.isEmpty())
        {
            usuario = findByMatricula(matricula);
            if (usuario!=null && usuario.getContraseña().equals(password))
            {
                return true;
            }
        }
        return false;
    }
}
