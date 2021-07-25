package com.gabrielpedrico.proposta.proposta.dtos.carteirasamsung;

import com.gabrielpedrico.proposta.proposta.enums.TipoCarteira;
import com.gabrielpedrico.proposta.proposta.models.CarteiraPaypal;
import com.gabrielpedrico.proposta.proposta.models.CarteiraSamsung;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovaCarteiraSamsungRequest {

    @Email
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoCarteira carteira;

    public NovaCarteiraSamsungRequest(String email, TipoCarteira carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    @Deprecated
    public NovaCarteiraSamsungRequest(){
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getCarteira() {
        return carteira;
    }

    public CarteiraSamsung conversor(String numeroCartao) {
        return new CarteiraSamsung(this.email,numeroCartao);
    }
}
