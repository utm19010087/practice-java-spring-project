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
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/22
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService
{
    @Autowired
    private IUsuarioDao usuarioDao;
    /**
     * Guarda un nuevo usuario.
     *
     * @param usuario El usuario a guardar.
     */
    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }
    /**
     * Elimina un usuario por su identificador.
     *
     * @param id El identificador del usuario a eliminar.
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id>0)
        {
            usuarioDao.deleteById(id);
        }
    }
    /**
     * Busca un usuario por su identificador.
     *
     * @param id El identificador del usuario a buscar.
     * @return El usuario encontrado o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }
    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de todos los usuarios.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return List.copyOf(usuarioDao.findAll());
    }
    /**
     * Busca un usuario por su matrícula.
     *
     * @param matricula La matrícula del usuario a buscar.
     * @return El usuario encontrado o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Usuario findByMatricula(String matricula) {
        return usuarioDao.findUsuarioByMatricula(matricula);
    }
    /**
     * Realiza la autenticación de un usuario con matrícula y contraseña.
     *
     * @param matricula La matrícula del usuario.
     * @param password  La contraseña del usuario.
     * @return true si la autenticación es exitosa, false en caso contrario.
     */
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
