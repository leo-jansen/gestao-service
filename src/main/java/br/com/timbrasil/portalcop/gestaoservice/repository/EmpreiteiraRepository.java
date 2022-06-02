package br.com.timbrasil.portalcop.gestaoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.gestaoservice.model.Empreiteira;

public interface EmpreiteiraRepository extends JpaRepository<Empreiteira, Integer> {
  @Query(name = "SELECT e.id, e.nomeEmpreiteira FROM empreiteira e WHERE e.empreiteiraAtiva = 1 ORDER BY e.id", nativeQuery = true)
  List<Empreiteira> findAllEmpreiteiraAtiva();
  
}
