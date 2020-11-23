package br.com.zup.estrelas.prefeitura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.prefeitura.entity.Secretaria;


//FIXME: Por quê a opção pelo JpaRepository aqui?
@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {

}

