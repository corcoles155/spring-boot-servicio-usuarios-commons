package org.sanchez.corcoles.ana.pruebasconcepto.usuarios.commons.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true)
    private String nombre;

    //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles") //Si queremos que haya una relación bidireccional. Con mappedBy indicamos como se llama el campo la clase Usuario
    //private List<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
