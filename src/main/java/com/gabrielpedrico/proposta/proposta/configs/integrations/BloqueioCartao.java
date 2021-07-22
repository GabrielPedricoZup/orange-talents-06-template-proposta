package com.gabrielpedrico.proposta.proposta.configs.integrations;

import com.gabrielpedrico.proposta.proposta.dtos.cartao.CartaoResponse;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaResponse;
import com.gabrielpedrico.proposta.proposta.enums.StatusSolicitacao;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

@FeignClient(url = "${cartoes.url}", name = "bloqueioCartao")
public interface BloqueioCartao {

    @GetMapping("/{id}")
    CartaoResponse getCartao(@PathVariable String id);

/*    @CircuitBreaker(name = "bloquearCartao", fallbackMethod = "analiseFallback")*/
    @PostMapping("/{id}/bloqueios")
    void bloquearCartao(@PathVariable String id, Object sistemaResponsavel);

/*  default ResponseEntity<?> analiseFallback(FeignException e) {
        if (e.status() == 404) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar o cartão no sistema legado");
        }
        if(e.status() == 422){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Cartão já foi bloqueado");
        }

        return ResponseEntity.badRequest().build();
    }*/

}
