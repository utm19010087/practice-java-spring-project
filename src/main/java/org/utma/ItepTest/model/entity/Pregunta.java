package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Pregunta representa la entidad "preguntas" en la base de datos.
 *
 * <p>
 * Esta clase se utiliza para mapear los datos de la tabla "preguntas" a objetos en Java.
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
 * <p>
 * La relación @OneToMany indica que esta entidad tiene una relación de uno a muchos con la entidad Respuesta.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de software - UTMA
 * @version 0.1,
 */
@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable
{
    /**
     * Identificador único de la pregunta en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preguntas")
    private Long idPreguntas;

    /**
     * Texto de la pregunta.
     */
    private String texto;

    /**
     * Nivel de dificultad de la pregunta.
     */
    private String nivel;

    /**
     * Identificador de la categoría a la que pertenece la pregunta.
     */
    @Column(name = "fk_id_categorias")
    private Long fkIdCategorias;

    /**
     * Lista de respuestas asociadas a la pregunta.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_preguntas")
    private List<Respuesta> respuestas;

    /**
     * Constructor por defecto que inicializa la lista de respuestas.
     */
    public Pregunta()
    {
        respuestas = new ArrayList<>(100);
    }

    /**
     * Obtiene el identificador único de la pregunta.
     *
     * @return El identificador único de la pregunta.
     */
    public Long getIdPreguntas() {
        return idPreguntas;
    }

    /**
     * Establece el identificador único de la pregunta.
     *
     * @param idPreguntas El identificador único de la pregunta a establecer.
     */
    public void setIdPreguntas(Long idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    /**
     * Obtiene el texto de la pregunta.
     *
     * @return El texto de la pregunta.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el texto de la pregunta.
     *
     * @param texto El texto de la pregunta a establecer.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene el nivel de dificultad de la pregunta.
     *
     * @return El nivel de dificultad de la pregunta.
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel de dificultad de la pregunta.
     *
     * @param nivel El nivel de dificultad de la pregunta a establecer.
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtiene el identificador de la categoría a la que pertenece la pregunta.
     *
     * @return El identificador de la categoría.
     */
    public Long getFkIdCategorias() {
        return fkIdCategorias;
    }

    /**
     * Establece el identificador de la categoría a la que pertenece la pregunta.
     *
     * @param fkIdCategorias El identificador de la categoría a establecer.
     */
    public void setFkIdCategorias(Long fkIdCategorias) {
        this.fkIdCategorias = fkIdCategorias;
    }

    /**
     * Obtiene la lista de respuestas asociadas a la pregunta.
     *
     * @return La lista de respuestas.
     */
    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    /**
     * Establece la lista de respuestas asociadas a la pregunta.
     *
     * @param respuestas La lista de respuestas a establecer.
     */
    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
