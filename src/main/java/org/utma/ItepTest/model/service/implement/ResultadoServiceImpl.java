package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.IResultadoDao;
import org.utma.ItepTest.model.entity.Pregunta;
import org.utma.ItepTest.model.entity.Respuesta;
import org.utma.ItepTest.model.entity.Resultado;
import org.utma.ItepTest.model.service.IPreguntaService;
import org.utma.ItepTest.model.service.IResultadoService;
import org.utma.ItepTest.model.service.IUsuarioService;
import org.utma.ItepTest.model.service.dto.RespuestaDto;

import java.util.Date;
import java.util.List;
/**
 * Implementación de la interfaz IResultadoService que proporciona operaciones de servicio relacionadas con la entidad Resultado.
 *
 * <p>
 * Esta clase utiliza la anotación `@Service` de Spring para indicar que es un componente de servicio.
 * Proporciona métodos transaccionales para realizar operaciones CRUD en la entidad Resultado, así como operaciones específicas
 * para gestionar resultados en relación con usuarios, preguntas y respuestas.
 * </p>
 *
 * @author [Nombre del autor]
 * @version [Versión del software o clase]
 */
@Service
public class ResultadoServiceImpl implements IResultadoService
{
    @Autowired
    private IResultadoDao resultadoDao;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPreguntaService preguntaService;

    /**
     * Guarda un nuevo resultado.
     *
     * @param resultado El resultado a guardar.
     */
    @Override
    @Transactional
    public void save(Resultado resultado)
    {
        if (resultado != null)
        {
            resultadoDao.save(resultado);
        }
    }
    /**
     * Elimina un resultado por su identificador.
     *
     * @param id El identificador del resultado a eliminar.
     */
    @Override
    @Transactional
    public void deleteById(Long id)
    {
        if (id > 0)
        {
            resultadoDao.deleteById(id);
        }
    }
    /**
     * Busca un resultado por su identificador.
     *
     * @param id El identificador del resultado a buscar.
     * @return El resultado encontrado o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Resultado findById(Long id)
    {
        return resultadoDao.findById(id).orElse(null);
    }
    /**
     * Obtiene todos los resultados.
     *
     * @return Lista de todos los resultados.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Resultado> findAll()
    {
        return List.copyOf(resultadoDao.findAll());
    }

    /**
     * Guarda respuestas asociadas a un usuario, pregunta y respuesta específicos.
     *
     * @param respuestaDto DTO que contiene respuestas, índices de preguntas y el ID del usuario asociado.
     */
    @Override
    @Transactional
    public void saveRespuestaWithUsuarioWithPreguntaWithRespuestaWithUsuario(RespuestaDto respuestaDto)
    {
        Respuesta[] respuestas = respuestaDto.getSelector();
        int[] preguntaIds = respuestaDto.getPreguntaIndex();
        Long usuarioId = respuestaDto.getUsuarioId();

        for (int i=0; i<respuestas.length; i++)
        {
            Respuesta respuesta = respuestas[i];
            if (respuesta != null && preguntaIds[i] > 0)
            {
                Resultado resultado = new Resultado();
                resultado.setUsuario(usuarioService.findById(usuarioId));
                resultado.setPregunta(preguntaService.findById((long) preguntaIds[i]));
                resultado.setRespuesta(respuesta);
                resultado.setCreateAt(new Date());
                save(resultado);
            }
        }
    }
    /**
     * Obtiene una página de resultados asociados a un usuario.
     *
     * @param id       El identificador del usuario.
     * @param pageable Configuración de paginación.
     * @return Página de resultados asociados al usuario.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Resultado> findResultadoByUsuarioId(Long id, Pageable pageable) {
        return resultadoDao.findResultadoByUsuarioId(id, pageable);
    }
    /**
     * Elimina todos los resultados asociados a un usuario por su identificador.
     *
     * @param id El identificador del usuario.
     */
    @Override
    @Transactional
    public void deleteResultadoByUsuarioId(Long id) {
        resultadoDao.deleteResultadoByUsuarioId(id);
    }

    /**
     * Obtiene la cantidad de resultados correctos asociados a un usuario por su identificador.
     *
     * @param id El identificador del usuario.
     * @return Cantidad de resultados correctos.
     */
    @Override
    @Transactional(readOnly = true)
    public int findResultadoByUsuarioIdWhereIsCorrect(Long id) {
        return resultadoDao.findResultadoByUsuarioWhereRespuestaIsCorrect(id);
    }
}
