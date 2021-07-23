package com.gabrielpedrico.proposta.proposta.dtos.avisoviagem;

import com.gabrielpedrico.proposta.proposta.models.AvisoViagem;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class NovoAvisoViagemRequest {

    @NotEmpty
    private String destinoViagem;

    @Future
    private LocalDate dataTermino;

    public NovoAvisoViagemRequest(String destinoViagem, LocalDate dataTermino) {
        this.destinoViagem = destinoViagem;
        this.dataTermino = dataTermino;
    }

    public String getDestinoViagem() {
        return destinoViagem;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public AvisoViagem conversor(String numeroCartao,String ipRequest,String userAgent) {

        return new AvisoViagem(numeroCartao,this.destinoViagem,this.dataTermino,ipRequest,userAgent);
    }
}
