package com.example.backendmodule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "beneficio")
public class Beneficio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;


    @Positive
    private BigDecimal valor;

    @PrePersist
    public void prePersist() {
        if (ativo == null) {
            ativo = true;
        }
    }
    private Boolean ativo = true;



    @Version
    private Long version;

}
