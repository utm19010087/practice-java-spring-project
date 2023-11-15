package org.utma.ItepTest.model.service;

import org.utma.ItepTest.model.dao.IUsuarioDao;
import org.utma.ItepTest.model.entity.Usuario;
import org.utma.ItepTest.model.service.IService;

public interface IUsuarioService extends IService<Usuario>
{
    public Usuario findByMatricula(String matricula);

    public boolean loginWithMatriculaWithPassword(String matricula, String password);
}
