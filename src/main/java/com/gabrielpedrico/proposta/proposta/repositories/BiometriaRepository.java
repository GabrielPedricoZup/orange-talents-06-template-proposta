package com.gabrielpedrico.proposta.proposta.repositories;

import com.gabrielpedrico.proposta.proposta.models.Biometria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiometriaRepository extends JpaRepository<Biometria, Long> {
}
