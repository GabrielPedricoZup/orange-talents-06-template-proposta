package com.gabrielpedrico.proposta.proposta.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String impressaoDigital;

    private String numeroCartao;

    @CreationTimestamp
    private LocalDateTime dataRegistro;

    public Biometria(String impressaoDigital, String numeroCartao) {
        this.impressaoDigital = impressaoDigital;
        this.numeroCartao = numeroCartao;
    }

    public Long getId() {
        return id;
    }

    public String getImpressaoDigital() {
        return impressaoDigital;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
}
