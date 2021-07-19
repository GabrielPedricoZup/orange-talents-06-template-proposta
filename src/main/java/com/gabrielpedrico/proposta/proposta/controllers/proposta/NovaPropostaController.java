package com.gabrielpedrico.proposta.proposta.controllers.proposta;

import com.gabrielpedrico.proposta.proposta.configs.integrations.AnalisaCliente;
import com.gabrielpedrico.proposta.proposta.dtos.proposta.NovaPropostaRequest;
import com.gabrielpedrico.proposta.proposta.models.Proposta;
import com.gabrielpedrico.proposta.proposta.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NovaPropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AnalisaCliente analise;

    @PostMapping("/proposta")
    @Transactional
    public ResponseEntity<?> cadastrarProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriComponentsBuilder){

        Proposta proposta = request.conversor();
        propostaRepository.save(proposta);
        proposta.setaStatus(analise);
        propostaRepository.save(proposta);
        return ResponseEntity.created(uriComponentsBuilder.path("/proposta/{id}")
                .buildAndExpand(proposta.getId()).toUri()).build();
    }
}
