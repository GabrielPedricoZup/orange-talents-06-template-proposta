package com.gabrielpedrico.proposta.proposta.dtos.biometria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.gabrielpedrico.proposta.proposta.validators.IsBase64;

import javax.validation.constraints.NotBlank;

public class NovaBiometriaRequest {

    @NotBlank
    @IsBase64(message = "Não está no formato Base64")
    private String impressaoDigital;

    @JsonCreator(mode = Mode.PROPERTIES)
    public NovaBiometriaRequest(String impressaoDigital) {
        this.impressaoDigital = impressaoDigital;
    }

    public String getImpressaoDigital() {
        return impressaoDigital;
    }
}
