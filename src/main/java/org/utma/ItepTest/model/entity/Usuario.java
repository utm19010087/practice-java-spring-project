package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * La clase Usuario representa la entidad "usuarios" en la base de datos.
 *
 * <p>
 * Esta clase se utiliza para mapear los datos de la tabla "usuarios" a objetos en Java.
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
 * La anotación @Pattern se utiliza para aplicar una expresión regular a la propiedad matricula, asegurando que cumple con el patrón especificado.
 * </p>
 *
 * <p>
 * La relación @ManyToMany indica que esta entidad tiene una relación de muchos a muchos con la entidad Respuesta.
 * </p>
 *
 * @author [Nombre del autor]
 * @version [Versión del software o clase]
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    /**
     * Identificador único del usuario en la base de datos.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios")
    private Long idUsuarios;
    /**
     * Nombre del usuario.
     */
    private String nombre;
    /**
     * Dirección de correo electrónico del usuario.
     */
    private String email;

    /**
     * Matrícula del usuario, con validación de patrón utilizando la expresión regular "utm\\d{8}".
     */

    @Pattern(regexp = "utm\\d{8}")
    private String matricula;
    /**
     * Contraseña del usuario.
     */
    private String contraseña;
    /**
     * Fecha y hora de creación del usuario.
     */
    @Column(name = "create_at")
    private Date createAt;
    /**
     * Fecha de la última aplicación del usuario.
     */

    @Temporal(TemporalType.DATE)
    @Column(name = "ultima_aplicacion")
    private Date ultimaAplicacion;
    /**
     * Última puntuación del usuario.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "ultima_puntuacion")
    private int ultimaPuntuacion;
    /**
     * Lista de respuestas asociadas al usuario mediante la relación muchos a muchos.
     */
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "usuarios_respuestas", joinColumns = @JoinColumn(name = "respuesta_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Respuesta> respuestas;
    /**
     * Obtiene la lista de respuestas asociadas al usuario.
     *
     * @return La lista de respuestas.
     */
    public List<Respuesta> getRespuestas() {
        return respuestas;
    }
    /**
     * Establece la lista de respuestas asociadas al usuario.
     *
     * @param respuestas La lista de respuestas a establecer.
     */
    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    /**
     * Agrega una respuesta a la lista de respuestas del usuario y establece la asociación inversa.
     *
     * @param respuesta La respuesta a agregar.
     */
    public void addRespuesta(Respuesta respuesta)
    {
        respuestas.add(respuesta);
        respuesta.getUsuarios().add(this);
    }
    /**
     * Elimina una respuesta de la lista de respuestas del usuario y elimina la asociación inversa.
     *
     * @param respuesta La respuesta a eliminar.
     */
    public void removeRespuesta(Respuesta respuesta)
    {
        respuestas.remove(respuesta);
        respuesta.getUsuarios().remove(this);
    }
    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public Long getIdUsuarios() {
        return idUsuarios;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param idUsuarios El identificador único del usuario a establecer.
     */
    public void setIdUsuarios(Long idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección de correo electrónico del usuario.
     *
     * @return La dirección de correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Establece la dirección de correo electrónico del usuario.
     *
     * @param email La dirección de correo electrónico del usuario a establecer.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Obtiene la matrícula del usuario.
     *
     * @return La matrícula del usuario.
     */
    public String getMatricula() {
        return matricula;
    }
    /**
     * Establece la matrícula del usuario.
     *
     * @param matricula La matrícula del usuario a establecer.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }
    /**
     * Establece la contraseña del usuario.
     *
     * @param contraseña La contraseña del usuario a establecer.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /**
     * Obtiene la fecha y hora de creación del usuario.
     *
     * @return La fecha y hora de creación del usuario.
     */
    public Date getCreateAt() {
        return createAt;
    }
    /**
     * Establece la fecha y hora de creación del usuario.
     *
     * @param createAt La fecha y hora de creación del usuario a establecer.
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * Obtiene la fecha de la última aplicación del usuario.
     *
     * @return La fecha de la última aplicación del usuario.
     */
    public Date getUltimaAplicacion() {
        return ultimaAplicacion;
    }
    /**
     * Establece la fecha de la última aplicación del usuario.
     *
     * @param ultimaAplicacion La fecha de la última aplicación del usuario a establecer.
     */
    public void setUltimaAplicacion(Date ultimaAplicacion) {
        this.ultimaAplicacion = ultimaAplicacion;
    }
    /**
     * Obtiene la última puntuación del usuario.
     *
     * @return La última puntuación del usuario.
     */
    public int getUltimaPuntuacion() {
        return ultimaPuntuacion;
    }
    /**
     * Establece la última puntuación del usuario.
     *
     * @param ultimaPuntuacion La última puntuación del usuario a establecer.
     */
    public void setUltimaPuntuacion(int ultimaPuntuacion) {
        this.ultimaPuntuacion = ultimaPuntuacion;
    }
}
