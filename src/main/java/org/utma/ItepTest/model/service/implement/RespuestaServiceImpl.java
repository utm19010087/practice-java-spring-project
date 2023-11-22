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
/**
 * Implementación de la interfaz IRespuestaService que proporciona operaciones de servicio relacionadas con la entidad Respuesta.
 *
 * <p>
 * Esta clase utiliza la anotación `@Service` de Spring para indicar que es un componente de servicio.
 * Proporciona métodos transaccionales para realizar operaciones CRUD en la entidad Respuesta.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/22
 */
@Service
public class RespuestaServiceImpl implements IRespuestaService
{
    /**
     * Inyección de dependencia del DAO de Respuesta.
     */
    @Autowired
    private IRespuestaDao respuestaDao;
    /**
     * Guarda una nueva respuesta.
     *
     * @param respuesta La respuesta a guardar.
     */
    @Override
    @Transactional
    public void save(Respuesta respuesta) {
        respuestaDao.save(respuesta);
    }
    /**
     * Elimina una respuesta por su identificador.
     *
     * @param id El identificador de la respuesta a eliminar.
     */
    @Override
    @Transactional
    public void deleteById(Long id)
    {
        if (id>0)
        {
            respuestaDao.deleteById(id);
        }
    }
    /**
     * Busca una respuesta por su identificador.
     *
     * @param id El identificador de la respuesta a buscar.
     * @return La respuesta encontrada o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Respuesta findById(Long id) {
        return respuestaDao.findById(id).orElse(null);
    }
    /**
     * Obtiene todas las respuestas.
     *
     * @return Lista de todas las respuestas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Respuesta> findAll() {
        return List.copyOf(respuestaDao.findAll());
    }
}
