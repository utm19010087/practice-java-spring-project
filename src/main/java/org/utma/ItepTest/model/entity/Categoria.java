package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * La clase Categoria representa la entidad "categorias" en la base de datos.
 *
 * <p>
 * Esta clase se utiliza para mapear los datos de la tabla "categorias" a objetos en Java.
 * </p>
 *
 * <p>
 * La anotación @Entity indica que esta clase es una entidad JPA (Java Persistence API) y se puede almacenar en una base de datos.
 * </p>
 *
 * <p>
 * La anotación @Table especifica el nombre de la tabla en la base de datos a la que se asocia esta entidad.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de software - UTMA
 * @version 0.1, 2023/11/22
 */
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable
{

    /**
     * Identificador único de la categoría en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorias")
    private Long idCategorias;

    /**
     * Nombre de la categoría.
     */
    private String nombre;

    /**
     * Obtiene el identificador único de la categoría.
     *
     * @return El identificador único de la categoría.
     */
    public Long getIdCategorias() {
        return idCategorias;
    }

    /**
     * Establece el identificador único de la categoría.
     *
     * @param idCategorias El identificador único de la categoría a establecer.
     */
    public void setIdCategorias(Long idCategorias) {
        this.idCategorias = idCategorias;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return El nombre de la categoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return El nombre de la categoría.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
