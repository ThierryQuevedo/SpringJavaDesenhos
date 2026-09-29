package com.desenho.cadastro_desenho.infrastrucure.repository;

import com.desenho.cadastro_desenho.infrastrucure.entitys.Desenho;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Optional;

public interface DesenhoRepository extends JpaRepository<Desenho, Integer> {
    Optional <Desenho> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}
