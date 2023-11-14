package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "respuestas")
public class Respuesta implements Serializable {

    @ManyToMany(mappedBy = "respuestas")
    public List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuestas")
    private Long idRespuestas;
    private String texto;
    @Column(name = "is_correct")
    private Boolean isCorrect;
    @Column(name = "fk_id_preguntas")
    private int fkIdPreguntas;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    private Pregunta pregunta;

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    */
    public Long getIdRespuestas() {
        return idRespuestas;
    }

    public void setIdRespuestas(Long idRespuestas) {
        this.idRespuestas = idRespuestas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public int getFkIdPreguntas() {
        return fkIdPreguntas;
    }

    public void setFkIdPreguntas(int fkIdPreguntas) {
        this.fkIdPreguntas = fkIdPreguntas;
    }
}

