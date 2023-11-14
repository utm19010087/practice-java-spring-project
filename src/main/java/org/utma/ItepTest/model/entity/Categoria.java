package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorias")
    private Long idCategorias;
    private String nombre;

    public Long getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Long idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
