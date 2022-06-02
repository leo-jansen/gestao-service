package br.com.timbrasil.portalcop.gestaoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timbrasil.portalcop.gestaoservice.model.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Integer> {
  
}
