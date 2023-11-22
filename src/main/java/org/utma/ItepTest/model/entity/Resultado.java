package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
/**
 * La clase Resultado representa la entidad "resultados" en la base de datos.
 *
 * <p>
 * Esta clase se utiliza para mapear los datos de la tabla "resultados" a objetos en Java.
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
 * La relación @ManyToOne indica que esta entidad tiene una relación de muchos a uno con las entidades Usuario, Respuesta y Pregunta.
 * </p>
 *
 * @author Francisco Javier Gonzalez Huerta / Fabrica de Software - UTMA
 * @version 0.1, 2023/11/22
 */
@Entity
@Table(name = "resultados")
public class Resultado implements Serializable
{
    /**
     * Identificador único del resultado en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultados")
    private Long idResultado;
    /**
     * Usuario asociado al resultado mediante la relación muchos a uno.
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_usuarios")
    private Usuario usuario;
    /**
     * Respuesta asociada al resultado mediante la relación muchos a uno.
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_respuestas")
    private Respuesta respuesta;
    /**
     * Pregunta asociada al resultado mediante la relación muchos a uno.
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_preguntas")
    private Pregunta pregunta;
    /**
     * Fecha y hora de creación del resultado.
     */
    @Column(name = "create_at")
    private Date createAt;
    /**
     * Obtiene el identificador único del resultado.
     *
     * @return El identificador único del resultado.
     */
    public Long getIdResultado() {
        return idResultado;
    }
    /**
     * Establece el identificador único del resultado.
     *
     * @param idResultado El identificador único del resultado a establecer.
     */
    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }
    /**
     * Obtiene el usuario asociado al resultado.
     *
     * @return El usuario asociado al resultado.
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * Establece el usuario asociado al resultado.
     *
     * @param usuario El usuario asociado al resultado.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     * Obtiene la respuesta asociada al resultado.
     *
     * @return La respuesta asociada al resultado.
     */
    public Respuesta getRespuesta() {
        return respuesta;
    }
    /**
     * Establece la respuesta asociada al resultado.
     *
     * @param respuesta La respuesta asociada al resultado.
     */
    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }
    /**
     * Obtiene la pregunta asociada al resultado.
     *
     * @return La pregunta asociada al resultado.
     */
    public Pregunta getPregunta() {
        return pregunta;
    }
    /**
     * Establece la pregunta asociada al resultado.
     *
     * @param pregunta La pregunta asociada al resultado.
     */
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    /**
     * Obtiene la fecha y hora de creación del resultado.
     *
     * @return La fecha y hora de creación del resultado.
     */
    public Date getCreateAt() {
        return createAt;
    }
    /**
     * Establece la fecha y hora de creación del resultado.
     *
     * @param createAt La fecha y hora de creación del resultado.
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
