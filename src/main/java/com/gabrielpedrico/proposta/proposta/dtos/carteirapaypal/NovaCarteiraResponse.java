package com.gabrielpedrico.proposta.proposta.dtos.carteirapaypal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrielpedrico.proposta.proposta.enums.TipoCarteira;

public class NovaCarteiraResponse {

    private String email;

    @JsonProperty("carteira")
    private TipoCarteira tipoCarteira;

    public NovaCarteiraResponse(String email, TipoCarteira tipoCarteira) {
        this.email = email;
        this.tipoCarteira = tipoCarteira;
    }

    @Deprecated
    public NovaCarteiraResponse(){
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getTipoCarteira() {
        return tipoCarteira;
    }
}
