package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
/**
 * La clase Respuesta representa la entidad "respuestas" en la base de datos.
 *
 * <p>
 * Esta clase se utiliza para mapear los datos de la tabla "respuestas" a objetos en Java.
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
 * La relación @ManyToMany indica que esta entidad tiene una relación de muchos a muchos con la entidad Usuario.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version [Versión del software o clase]
 */
@Entity
@Table(name = "respuestas")
public class Respuesta implements Serializable {
    /**
     * Identificador único de la respuesta en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuestas")
    private Long idRespuestas;
    /**
     * Texto de la respuesta.
     */
    private String texto;
    /**
     * Indica si la respuesta es correcta o no.
     */

    @Column(name = "is_correct")
    private Boolean isCorrect;
    /**
     * Valor asociado a la respuesta.
     */
    private int valor;
    /**
     * Identificador de la pregunta a la que pertenece la respuesta.
     */
    @Column(name = "fk_id_preguntas")
    private int fkIdPreguntas;
    /**
     * Lista de usuarios asociados a la respuesta mediante la relación muchos a muchos.
     */
    @ManyToMany(mappedBy = "respuestas")
    public List<Usuario> usuarios;
    /**
     * Obtiene la lista de usuarios asociados a la respuesta.
     *
     * @return La lista de usuarios.
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios asociados a la respuesta.
     *
     * @param usuarios La lista de usuarios a establecer.
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    /**
     * Obtiene el identificador único de la respuesta.
     *
     * @return El identificador único de la respuesta.
     */
    public Long getIdRespuestas() {
        return idRespuestas;
    }
    /**
     * Establece el identificador único de la respuesta.
     *
     * @param idRespuestas El identificador único de la respuesta a establecer.
     */
    public void setIdRespuestas(Long idRespuestas) {
        this.idRespuestas = idRespuestas;
    }
    /**
     * Obtiene el texto de la respuesta.
     *
     * @return El texto de la respuesta.
     */
    public String getTexto() {
        return texto;
    }
    /**
     * Establece el texto de la respuesta.
     *
     * @param texto El texto de la respuesta a establecer.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
    /**
     * Obtiene si la respuesta es correcta o no.
     *
     * @return true si la respuesta es correcta, false si no lo es.
     */
    public Boolean getIsCorrect() {
        return isCorrect;
    }
    /**
     * Establece si la respuesta es correcta o no.
     *
     * @param correct Indica si la respuesta es correcta.
     */
    public void setIsCorrect(Boolean correct) {
        isCorrect = correct;
    }
    /**
     * Obtiene el identificador de la pregunta a la que pertenece la respuesta.
     *
     * @return El identificador de la pregunta.
     */
    public int getFkIdPreguntas() {
        return fkIdPreguntas;
    }
    /**
     * Establece el identificador de la pregunta a la que pertenece la respuesta.
     *
     * @param fkIdPreguntas El identificador de la pregunta a establecer.
     */
    public void setFkIdPreguntas(int fkIdPreguntas) {
        this.fkIdPreguntas = fkIdPreguntas;
    }
    /**
     * Obtiene el valor asociado a la respuesta.
     *
     * @return El valor asociado a la respuesta.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Establece el valor asociado a la respuesta.
     *
     * @param valor El valor a establecer.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
}

