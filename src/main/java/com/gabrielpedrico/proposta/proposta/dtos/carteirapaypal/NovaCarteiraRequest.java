package com.gabrielpedrico.proposta.proposta.dtos.carteirapaypal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrielpedrico.proposta.proposta.enums.TipoCarteira;
import com.gabrielpedrico.proposta.proposta.models.CarteiraPaypal;
import com.gabrielpedrico.proposta.proposta.validators.NotExists;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovaCarteiraRequest {

    @Email
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoCarteira carteira;

    public NovaCarteiraRequest(String email, TipoCarteira carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    @Deprecated
    public NovaCarteiraRequest(){
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getCarteira() {
        return carteira;
    }

    public CarteiraPaypal conversor(String numeroCartao) {
        return new CarteiraPaypal(this.email,numeroCartao);
    }
}
