package com.gabrielpedrico.proposta.proposta.controllers.carteirapaypal;

import com.gabrielpedrico.proposta.proposta.configs.integrations.AssociaCartao;
import com.gabrielpedrico.proposta.proposta.configs.integrations.CriaCarteira;
import com.gabrielpedrico.proposta.proposta.dtos.carteirapaypal.NovaCarteiraRequest;
import com.gabrielpedrico.proposta.proposta.models.CarteiraPaypal;
import com.gabrielpedrico.proposta.proposta.models.Proposta;
import com.gabrielpedrico.proposta.proposta.repositories.CarteiraPaypalRepository;
import com.gabrielpedrico.proposta.proposta.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
public class NovaCarteiraPaypalController {

    @Autowired
    CarteiraPaypalRepository carteiraPaypalRepository;

    @Autowired
    CriaCarteira criaCarteira;

    @Autowired
    PropostaRepository propostaRepository;

    @PostMapping("/carteiras/paypal/{id}")
    @Transactional
    public ResponseEntity<?> associaCarteira(@PathVariable String id,@RequestBody @Valid  NovaCarteiraRequest request){
        Optional<Proposta> possivelCartao = propostaRepository.findByNumeroCartao(id);
        Optional<CarteiraPaypal> existeCarteira = carteiraPaypalRepository.findByNumeroCartao(id);
        if (possivelCartao.isEmpty()){
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND,"Cartão não encontrado");
        }
        if(existeCarteira.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        CarteiraPaypal carteiraPaypal = request.conversor(id);
        criaCarteira.paypal(id, Map.of(
                "email", request.getEmail(),
                "carteira", request.getCarteira()));
        carteiraPaypalRepository.save(carteiraPaypal);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carteiraPaypal.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
