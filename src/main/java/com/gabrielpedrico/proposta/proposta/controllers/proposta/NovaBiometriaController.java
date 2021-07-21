package com.gabrielpedrico.proposta.proposta.controllers.proposta;

import com.gabrielpedrico.proposta.proposta.configs.integrations.AssociaCartao;
import com.gabrielpedrico.proposta.proposta.dtos.biometria.NovaBiometriaRequest;
import com.gabrielpedrico.proposta.proposta.models.Biometria;
import com.gabrielpedrico.proposta.proposta.repositories.BiometriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class NovaBiometriaController {

    @Autowired
    BiometriaRepository biometriaRepository;
    @Autowired
    AssociaCartao associaCartao;

    @PostMapping("/biometria/{id}")
    @Transactional
    public ResponseEntity<?> cadastraBiometria(@PathVariable String id, @Valid @RequestBody NovaBiometriaRequest request) {
        try {
           associaCartao.buscaCartaoById(id);
        } catch (ResponseStatusException e) {
            if (e.getMessage().startsWith("404"))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi prossível processar os dados do Cartão.");
        }
        Biometria biometria = biometriaRepository.save(new Biometria(request.getImpressaoDigital(), id));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}/")
                .buildAndExpand(biometria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
