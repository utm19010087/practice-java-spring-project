package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "respuestas")
public class Respuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuestas")
    private Long idRespuestas;

    private String texto;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    private int valor;

    @Column(name = "fk_id_preguntas")
    private int fkIdPreguntas;

    @ManyToMany(mappedBy = "respuestas")
    public List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

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

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public int getFkIdPreguntas() {
        return fkIdPreguntas;
    }

    public void setFkIdPreguntas(int fkIdPreguntas) {
        this.fkIdPreguntas = fkIdPreguntas;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}

