package com.gabrielpedrico.proposta.proposta.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AvisoViagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroCartao;

    @Column(nullable = false)
    private String destinoViagem;

    @Future
    private LocalDate dataTermino;

    @CreationTimestamp
    private LocalDateTime instanteCadastro;

    @Column(nullable = false)
    private String ipRequest;

    @Column(nullable = false)
    private String userAgent;

    public AvisoViagem(String numeroCartao, String destinoViagem, LocalDate dataTermino, String ipRequest, String userAgent) {
        this.numeroCartao = numeroCartao;
        this.destinoViagem = destinoViagem;
        this.dataTermino = dataTermino;
        this.ipRequest = ipRequest;
        this.userAgent = userAgent;
    }

    @Deprecated
    public AvisoViagem(){}

    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getDestinoViagem() {
        return destinoViagem;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }

    public String getIpRequest() {
        return ipRequest;
    }

    public String getUserAgent() {
        return userAgent;
    }
}
