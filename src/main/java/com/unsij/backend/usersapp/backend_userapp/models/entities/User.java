package com.unsij.backend.usersapp.backend_userapp.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Vamos a indircar a la calse Java que esto pertenecera a una tabla o entidad
@Table(name = "users") // Hacemos referencia a que tabla de la base de datos se va a mapear nuestro modelo
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Este es un mensaje personalizado.")
    @Column(unique = true) // Se puede especificar el nombre de la columna en la BD Ejemplo: @Column(unique = true, name = "usuario")
    private String username;

    @NotEmpty
    private String password;

    @NotBlank
    @Email
    @Size(min = 3,max = 25)
    @Column(unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
