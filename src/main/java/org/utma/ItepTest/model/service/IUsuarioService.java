package org.utma.ItepTest.model.service;

import org.utma.ItepTest.model.dao.IUsuarioDao;
import org.utma.ItepTest.model.entity.Usuario;
import org.utma.ItepTest.model.service.IService;
/**
 * Interfaz de servicio para la entidad Usuario.
 * Extiende la interfaz IService proporcionando métodos específicos para la entidad Usuario.
 *
 * @see IService
 * @see Usuario
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/05/21
 */
public interface IUsuarioService extends IService<Usuario>
{

    /**
     * Encuentra un usuario por matrícula.
     *
     * @param matricula La matrícula del usuario a buscar.
     * @return El usuario asociado a la matrícula especificada.
     */
    public Usuario findByMatricula(String matricula);
    /**
     * Verifica el inicio de sesión utilizando la matrícula y la contraseña proporcionadas.
     *
     * @param matricula La matrícula del usuario.
     * @param password  La contraseña del usuario.
     * @return true si el inicio de sesión es exitoso, false de lo contrario.
     */
    public boolean loginWithMatriculaWithPassword(String matricula, String password);
}
