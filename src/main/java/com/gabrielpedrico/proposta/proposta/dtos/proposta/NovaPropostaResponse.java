package com.gabrielpedrico.proposta.proposta.dtos.proposta;

import com.gabrielpedrico.proposta.proposta.enums.StatusSolicitacao;

public class NovaPropostaResponse {

    private StatusSolicitacao resultadoSolicitacao;

    public NovaPropostaResponse() { }

    public NovaPropostaResponse(StatusSolicitacao resultadoSolicitacao) {
        this.resultadoSolicitacao = resultadoSolicitacao;
    }
    public StatusSolicitacao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

}
