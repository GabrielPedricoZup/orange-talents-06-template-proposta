package com.gabrielpedrico.proposta.proposta.dtos.avisoviagem;

import com.gabrielpedrico.proposta.proposta.models.AvisoViagem;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class NovoAvisoViagemRequest {

    @NotEmpty
    private String destino;

    @Future
    private LocalDate validoAte;

    public NovoAvisoViagemRequest(String destino, LocalDate validoAte) {
        this.destino = destino;
        this.validoAte = validoAte;
    }

    public String getDestinoViagem() {
        return destino;
    }

    public LocalDate getDataTermino() {
        return validoAte;
    }

    public AvisoViagem conversor(String numeroCartao,String ipRequest,String userAgent) {

        return new AvisoViagem(numeroCartao,this.destino,this.validoAte,ipRequest,userAgent);
    }
}
