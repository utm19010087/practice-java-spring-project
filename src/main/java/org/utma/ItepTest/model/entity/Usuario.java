package org.utma.ItepTest.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios")
    private Long idUsuarios;

    private String nombre;

    private String email;

    @Pattern(regexp = "utm\\d{8}")
    private String matricula;

    private String contraseña;

    @Column(name = "create_at")
    private Date createAt;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "usuarios_respuestas", joinColumns = @JoinColumn(name = "respuesta_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Respuesta> respuestas;

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public void addRespuesta(Respuesta respuesta)
    {
        respuestas.add(respuesta);
        respuesta.getUsuarios().add(this);
    }

    public void removeRespuesta(Respuesta respuesta)
    {
        respuestas.remove(respuesta);
        respuesta.getUsuarios().remove(this);
    }

    public Long getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Long idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
