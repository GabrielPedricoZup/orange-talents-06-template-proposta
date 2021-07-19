package com.gabrielpedrico.proposta.proposta.configs.integrations;


import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaRequest;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaResponse;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.SolicitacaoRequest;
import com.gabrielpedrico.proposta.proposta.enums.StatusSolicitacao;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@FeignClient(name = "analisa",
        url = "http://localhost:9999/api/solicitacao")
public interface AnalisaCliente {

    @CircuitBreaker(name = "analisa", fallbackMethod = "analiseFallback")
    @PostMapping
    NovaPropostaResponse sendSolicitation(@RequestBody SolicitacaoRequest request);

    default NovaPropostaResponse analiseFallback(Exception ex) {
        if (ex.getClass() == FeignException.UnprocessableEntity.class) {
            return new NovaPropostaResponse(StatusSolicitacao.COM_RESTRICAO);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possível processar a análise da proposta");
    }

}
