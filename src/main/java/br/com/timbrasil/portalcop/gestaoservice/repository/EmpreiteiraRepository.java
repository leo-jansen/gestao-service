package br.com.timbrasil.portalcop.gestaoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.gestaoservice.model.Empreiteira;

public interface EmpreiteiraRepository extends JpaRepository<Empreiteira, Integer> {
  @Query(name = "SELECT e.id, e.nomeEmpreiteira FROM Empreiteira e WHERE e.empreiteiraAtiva = :empreiteiraAtiva ORDER BY e.id")
  List<Empreiteira> findByEmpreiteiraAtiva(int empreiteiraAtiva);
  
}
