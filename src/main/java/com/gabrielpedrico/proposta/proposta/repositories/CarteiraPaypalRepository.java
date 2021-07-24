package com.gabrielpedrico.proposta.proposta.repositories;

import com.gabrielpedrico.proposta.proposta.models.CarteiraPaypal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraPaypalRepository extends JpaRepository<CarteiraPaypal,Long> {
    Optional<CarteiraPaypal> findByNumeroCartao(String id);
}
