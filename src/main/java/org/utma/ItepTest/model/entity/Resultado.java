package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "resultados")
public class Resultado implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultados")
    private Long idResultado;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuarios")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_id_respuestas")
    private Respuesta respuesta;

    @ManyToOne
    @JoinColumn(name = "fk_id_preguntas")
    private Pregunta pregunta;

    @Column(name = "create_at")
    private Date createAt;

    public Long getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
