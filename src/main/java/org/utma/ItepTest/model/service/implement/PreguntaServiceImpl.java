package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.IPreguntaDao;
import org.utma.ItepTest.model.entity.Pregunta;
import org.utma.ItepTest.model.service.IPreguntaService;

import java.util.List;
/**
 * Implementación de la interfaz IPreguntaService que proporciona operaciones de servicio relacionadas con la entidad Pregunta.
 *
 * <p>
 * Esta clase utiliza la anotación `@Service` de Spring para indicar que es un componente de servicio.
 * Proporciona métodos transaccionales para realizar operaciones CRUD en la entidad Pregunta.
 * </p>
 *
 * @author [Nombre del autor]
 * @version [Versión del software o clase]
 */
@Service
public class PreguntaServiceImpl implements IPreguntaService
{
    /**
     * Inyección de dependencia del DAO de Pregunta.
     */
    @Autowired
    private IPreguntaDao preguntaDao;
    /**
     * Guarda una nueva pregunta.
     *
     * @param pregunta La pregunta a guardar.
     */
    @Override
    @Transactional
    public void save(Pregunta pregunta) {
        preguntaDao.save(pregunta);
    }

    /**
     * Elimina una pregunta por su identificador.
     *
     * @param id El identificador de la pregunta a eliminar.
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id>0)
        {
            preguntaDao.deleteById(id);
        }
    }
    /**
     * Busca una pregunta por su identificador.
     *
     * @param id El identificador de la pregunta a buscar.
     * @return La pregunta encontrada o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Pregunta findById(Long id) {
        return preguntaDao.findById(id).orElse(null);
    }
    /**
     * Obtiene todas las preguntas.
     *
     * @return Lista de todas las preguntas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Pregunta> findAll() {
        return List.copyOf(preguntaDao.findAll());
    }
}
