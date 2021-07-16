package com.gabrielpedrico.proposta.proposta.repositories;

import com.gabrielpedrico.proposta.proposta.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
}
