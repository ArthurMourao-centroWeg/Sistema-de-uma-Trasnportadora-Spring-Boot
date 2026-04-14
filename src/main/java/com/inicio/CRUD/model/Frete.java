package com.inicio.CRUD.model;

import com.inicio.CRUD.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Positive
    private int valor;
    @NotNull
    private Status status;
    @NotNull
    private String origem;
    @NotNull
    private String destino;
    @ManyToOne
    @JoinColumn(name = "caminhoneiro_id")
    private Caminhoneiro caminhoneiro;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private  Admin admin;

}
