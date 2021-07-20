package com.gabrielpedrico.proposta.proposta.configs.integrations;
//http://localhost:8888/api/cartoes?idProposta=1

import com.gabrielpedrico.proposta.proposta.dtos.cartao.CartaoResponse;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaResponse;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.SolicitacaoRequest;
import com.gabrielpedrico.proposta.proposta.enums.StatusSolicitacao;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@FeignClient(name = "associa",
        url = "${cartoes.url}")
public interface AssociaCartao {

    @GetMapping
    CartaoResponse buscaCartao(@RequestParam(required = true, name = "idProposta") String id);

}
