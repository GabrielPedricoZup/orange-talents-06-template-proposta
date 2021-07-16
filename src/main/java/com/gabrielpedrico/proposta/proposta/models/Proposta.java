package com.gabrielpedrico.proposta.proposta.models;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String documento;
    @NotBlank
    private String email;
    @Positive
    @NotNull
    private BigDecimal salario;

    public Proposta(String documento, String email, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.salario = salario;
    }

    @Deprecated
    public Proposta() {
    }
}
