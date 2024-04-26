package br.com.rgs.boxorganizer.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name="container")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long containerId;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    private String name;

    @CreationTimestamp
    private Instant createDate;

    @UpdateTimestamp
    private Instant updateDate;
}
