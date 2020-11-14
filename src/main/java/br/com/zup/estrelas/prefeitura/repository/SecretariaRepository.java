package br.com.zup.estrelas.prefeitura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.prefeitura.entity.Secretaria;



@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {

}

