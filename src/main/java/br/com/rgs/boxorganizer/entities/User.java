package br.com.rgs.boxorganizer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String userName;

    private String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name="roleId")
    )
    private Set<Role> roles;
}
