package com.gabrielpedrico.proposta.proposta.controllers.proposta;

import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaRequest;
import com.gabrielpedrico.proposta.proposta.models.Proposta;
import com.gabrielpedrico.proposta.proposta.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class NovaPropostaController {

    @Autowired
    PropostaRepository propostaRepository;

    @PostMapping("/proposta")
    public ResponseEntity<?> cadastrarProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriComponentsBuilder){

        Proposta proposta = request.conversor();
        propostaRepository.save(proposta);
        return ResponseEntity.created(uriComponentsBuilder.path("/proposta/{id}")
                .buildAndExpand(proposta.getId()).toUri()).build();
    }
}
