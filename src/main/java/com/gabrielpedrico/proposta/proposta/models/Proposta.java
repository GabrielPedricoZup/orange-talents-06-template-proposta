package com.gabrielpedrico.proposta.proposta.models;

import com.gabrielpedrico.proposta.proposta.configs.integrations.AnalisaCliente;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaRequest;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaResponse;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.SolicitacaoRequest;
import com.gabrielpedrico.proposta.proposta.enums.StatusProposta;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Optional;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotBlank
    private String email;
    @Positive
    @NotNull
    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private StatusProposta status = StatusProposta.ELEGIVEL;

    public Proposta(String documento,String nome,String endereco,String email, BigDecimal salario) {
        this.documento = documento;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.salario = salario;
    }

    @Deprecated
    public Proposta() {
    }

    public Long getId() {
        return id;
    }

    public void setaStatus(AnalisaCliente analise){
        try {
            SolicitacaoRequest solicitacaoRequest = new SolicitacaoRequest(this.documento, this.nome, this.id);
            NovaPropostaResponse response = analise.sendSolicitation(solicitacaoRequest);
            StatusProposta status =response.getResultadoSolicitacao().conversorStatus();
            this.status = status;
        }catch (NullPointerException e){
             e.printStackTrace();
        }
    }

}
