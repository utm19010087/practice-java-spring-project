package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preguntas")
    private Long idPreguntas;
    private String texto;
    private String nivel;
    @Column(name = "fk_id_categorias")
    private Long fkIdCategorias;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_preguntas")
    private List<Respuesta> respuestas;
    public Pregunta()
    {
        respuestas = new ArrayList<>(100);
    }
    public Long getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(Long idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Long getFkIdCategorias() {
        return fkIdCategorias;
    }

    public void setFkIdCategorias(Long fkIdCategorias) {
        this.fkIdCategorias = fkIdCategorias;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
