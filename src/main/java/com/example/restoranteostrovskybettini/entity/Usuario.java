package com.example.restoranteostrovskybettini.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@Entity
@Table(name="Usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    private String email;

    private String clave;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="usuario_roles"
            ,joinColumns=@JoinColumn(name="usuario_id", referencedColumnName = "id")
            ,inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}
