package com.gabrielpedrico.proposta.proposta.repositories;

import com.gabrielpedrico.proposta.proposta.enums.StatusProposta;
import com.gabrielpedrico.proposta.proposta.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    List<Proposta> findByStatusAndNumeroCartaoIsNull(StatusProposta elegivel);

    Proposta findByDocumento(String documento);

    Optional<Proposta> findByNumeroCartao(String numeroCartao);
}
