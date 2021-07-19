package com.gabrielpedrico.proposta.proposta.dtos.proposta;

public class SolicitacaoRequest {

    //proposal.getDocument(), proposal.getName(), proposal.getId()

    private String documento;
    private String nome;
    private String id;

    public SolicitacaoRequest(String documento, String nome, Long id) {
        this.documento = documento;
        this.nome = nome;
        this.id = id.toString();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
