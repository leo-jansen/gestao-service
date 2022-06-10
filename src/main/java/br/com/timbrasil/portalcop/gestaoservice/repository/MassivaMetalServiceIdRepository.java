package br.com.timbrasil.portalcop.gestaoservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.gestaoservice.model.MassivaMetalServiceId;

public interface MassivaMetalServiceIdRepository extends JpaRepository<MassivaMetalServiceId, Long>{
  @Query("select m from MassivaMetalServiceId m where m.fkMetalMassiva = :fk")
  Optional<MassivaMetalServiceId> findByFkMetalMassiva(String fk);
}
