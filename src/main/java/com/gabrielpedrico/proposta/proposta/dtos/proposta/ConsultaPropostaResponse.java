package com.gabrielpedrico.proposta.proposta.dtos.proposta;

import com.gabrielpedrico.proposta.proposta.enums.StatusProposta;

public class ConsultaPropostaResponse {

    private String nome;
    private StatusProposta status;

    public ConsultaPropostaResponse(String nome, StatusProposta status) {
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public StatusProposta getStatus() {
        return status;
    }
}
