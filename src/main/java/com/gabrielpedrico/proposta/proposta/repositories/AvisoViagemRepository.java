package com.gabrielpedrico.proposta.proposta.repositories;

import com.gabrielpedrico.proposta.proposta.models.AvisoViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisoViagemRepository extends JpaRepository<AvisoViagem,Long> {
}
