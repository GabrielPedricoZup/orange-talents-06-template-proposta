package com.gabrielpedrico.proposta.proposta.repositories;

import com.gabrielpedrico.proposta.proposta.models.CarteiraPaypal;
import com.gabrielpedrico.proposta.proposta.models.CarteiraSamsung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraSamsungRepository extends JpaRepository<CarteiraSamsung,Long> {
    Optional<CarteiraPaypal> findByNumeroCartao(String id);
}
