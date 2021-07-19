package com.gabrielpedrico.proposta.proposta.configs.integrations;

import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaRequest;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaResponse;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.SolicitacaoRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AnalisaClienteService implements AnalisaCliente {
    @Override
    public NovaPropostaResponse sendSolicitation(@RequestBody SolicitacaoRequest request) {
        return null;
    }

    @Override
    public NovaPropostaResponse analiseFallback(Exception ex) {
        return AnalisaCliente.super.analiseFallback(ex);
    }
}
