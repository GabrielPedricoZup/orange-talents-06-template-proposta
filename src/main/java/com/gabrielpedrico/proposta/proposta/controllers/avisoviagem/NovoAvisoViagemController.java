package com.gabrielpedrico.proposta.proposta.controllers.avisoviagem;

import com.gabrielpedrico.proposta.proposta.configs.integrations.AssociaCartao;
import com.gabrielpedrico.proposta.proposta.dtos.avisoviagem.NovoAvisoViagemRequest;
import com.gabrielpedrico.proposta.proposta.dtos.cartao.CartaoResponse;
import com.gabrielpedrico.proposta.proposta.models.AvisoViagem;
import com.gabrielpedrico.proposta.proposta.repositories.AvisoViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovoAvisoViagemController {

    @Autowired
    AvisoViagemRepository avisoViagemRepository;

    @Autowired
    AssociaCartao associaCartao;

    @PostMapping("/avisoviagem/{id}")
    @Transactional
    public ResponseEntity<?> cadastraAviso(@PathVariable String id, @RequestBody @Valid NovoAvisoViagemRequest request, @RequestHeader(value = "User-Agent") String userAgent, HttpServletRequest httpRequest){

        CartaoResponse cartao = associaCartao.buscaCartaoById(id);
        associaCartao.enviaAvisoViagem(id,request);
        AvisoViagem avisoViagem = request.conversor(id,httpRequest.getRemoteAddr(),userAgent);
        avisoViagemRepository.save(avisoViagem);

        return ResponseEntity.ok().build();
    }
}
