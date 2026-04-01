package com.inicio.CRUD.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Caminhoneiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(unique = true)
    private String cpf;
    @NotBlank
    @Column(unique = true)
    private String cnh;
    @NotBlank
    private String placaVeiculo;
}
