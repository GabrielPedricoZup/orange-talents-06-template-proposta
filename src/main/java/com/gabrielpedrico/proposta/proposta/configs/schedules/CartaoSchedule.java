package com.gabrielpedrico.proposta.proposta.configs.schedules;

import com.gabrielpedrico.proposta.proposta.configs.integrations.AssociaCartao;
import com.gabrielpedrico.proposta.proposta.dtos.cartao.CartaoResponse;
import com.gabrielpedrico.proposta.proposta.enums.StatusProposta;
import com.gabrielpedrico.proposta.proposta.models.Proposta;
import com.gabrielpedrico.proposta.proposta.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@EnableAsync
@EnableScheduling
public class CartaoSchedule {

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    AssociaCartao associaCartao;

    @Scheduled(fixedRate=60000)
    public void associaCartao() {

        List<Proposta> proposals = propostaRepository.
                findByStatusAndNumeroCartaoIsNull(StatusProposta.ELEGIVEL);
        proposals.forEach(p -> {
            try {
                CartaoResponse cartaoResponse = associaCartao.buscaCartao(p.getId().toString());
                p.setaCartao(cartaoResponse.getNumeroCartao());
                propostaRepository.save(p);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Não foi possível associar o cartão a proposta: " + e);
            }
        });

    }
}
