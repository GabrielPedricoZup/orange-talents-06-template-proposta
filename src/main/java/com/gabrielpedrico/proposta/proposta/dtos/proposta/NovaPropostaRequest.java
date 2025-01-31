package com.gabrielpedrico.proposta.proposta.dtos.proposta;

import com.gabrielpedrico.proposta.proposta.models.Proposta;
import com.gabrielpedrico.proposta.proposta.validators.CPFouCNPJ;
import com.gabrielpedrico.proposta.proposta.validators.NotExists;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class NovaPropostaRequest {

    @CPFouCNPJ
    @NotExists(domainClass = Proposta.class,fieldName = "documento",message = "Documento informado já existe proposta ativa")
    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @Email
    @NotBlank
    @NotExists(domainClass = Proposta.class,fieldName = "email",message = "Email informado já existe proposta ativa")
    private String email;
    @Positive
    @NotNull
    private BigDecimal salario;

    public NovaPropostaRequest(String documento,String nome,String endereco, String email, BigDecimal salario) {
        this.documento = documento;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.salario = salario;
    }

    public Proposta conversor(){
        return new Proposta(this.documento,this.nome,this.endereco,this.email,this.salario);
    }

    public String getDocumento() {
        return documento;
    }
}
