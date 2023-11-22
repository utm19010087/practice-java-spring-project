package org.utma.ItepTest.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utma.ItepTest.model.dao.ICategoriaDao;
import org.utma.ItepTest.model.entity.Categoria;
import org.utma.ItepTest.model.service.ICategoriaService;

import java.util.List;
/**
 * Implementación de la interfaz ICategoriaService que proporciona operaciones de servicio relacionadas con la entidad Categoria.
 *
 * <p>
 * Esta clase utiliza la anotación `@Service` de Spring para indicar que es un componente de servicio.
 * Proporciona métodos transaccionales para realizar operaciones CRUD en la entidad Categoria.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/22
 */
@Service
public class CategoriaServiceImpl implements ICategoriaService
{
    /**
     * Inyección de dependencia del DAO de Categoria.
     */
    @Autowired
    private ICategoriaDao categoriaDao;
    /**
     * Guarda una nueva categoria.
     *
     * @param categoria La categoria a guardar.
     */
    @Override
    @Transactional
    public void save(Categoria categoria)
    {
        categoriaDao.save(categoria);
    }
    /**
     * Elimina una categoria por su identificador.
     *
     * @param id El identificador de la categoria a eliminar.
     */
    @Override
    @Transactional
    public void deleteById(Long id)
    {
        if (id>0)
        {
            categoriaDao.deleteById(id);
        }
    }
    /**
     * Busca una categoria por su identificador.
     *
     * @param id El identificador de la categoria a buscar.
     * @return La categoria encontrada o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Long id)
    {
        return categoriaDao.findById(id).orElse(null);
    }
    /**
     * Obtiene todas las categorias.
     *
     * @return Lista de todas las categorias.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll()
    {
        return List.copyOf(categoriaDao.findAll());
    }
}
