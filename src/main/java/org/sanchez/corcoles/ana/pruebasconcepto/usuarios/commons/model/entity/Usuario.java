package org.sanchez.corcoles.ana.pruebasconcepto.usuarios.commons.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, length = 20)
    private String userName;

    @Column(length = 60)
    private String nombre;

    private String apellido;

    private Boolean enabled;

    @Column(unique = true, length = 100)
    private String email;

    private String password;

    /*
     * Se utiliza fetch para indicar la forma de obtener los datos, hay dos tipos:
     * LAZY, al realizar la consulta únicamente obtiene el usuario
     * EAGER, al realizar la consulta obtendrá el usuario + roles
     */
    @ManyToMany(fetch = FetchType.LAZY)
    //Con la anotación @JoinTable podemos modificar el nombre de la tabla y con @JoinColumn podemos modificar el nombre de las foreign key
    //Ponemos la anotación @UniqueConstraint para que un usuario no pueda tener el rol repetido (alter table usuarios_roles add constraint UKqjaspm7473pnu9y4jxhrds8r2 unique (usuario_id, role_id))
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
    private List<Rol> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
