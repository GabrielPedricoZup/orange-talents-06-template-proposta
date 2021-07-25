package com.gabrielpedrico.proposta.proposta.models;

import com.gabrielpedrico.proposta.proposta.enums.TipoCarteira;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class CarteiraSamsung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String email;

    @Column(unique = true)
    private String numeroCartao;

    private TipoCarteira tipoCarteira = TipoCarteira.SAMSUNGPAY;

    public CarteiraSamsung(String email,String numeroCartao) {
        this.email = email;
        this.numeroCartao = numeroCartao;
    }

    @Deprecated
    public CarteiraSamsung(){
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public TipoCarteira getTipoCarteira() {
        return tipoCarteira;
    }
}
