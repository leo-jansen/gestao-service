package br.com.timbrasil.portalcop.gestaoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.gestaoservice.model.Massiva;

public interface MassivaRepository extends JpaRepository<Massiva, Integer> {
  @Query("SELECT COUNT(m) FROM Massiva m WHERE m.getParInicio <= :parInicio AND m.getParFim >= :parFim AND m.getMsan = :msan")
  Long findByParInicioAndParFimAndMsan(String parInicio, String parFim, String msan);

}
