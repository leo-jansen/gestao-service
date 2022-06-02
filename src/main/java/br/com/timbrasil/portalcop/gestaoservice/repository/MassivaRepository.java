package br.com.timbrasil.portalcop.gestaoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.gestaoservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.gestaoservice.dto.RelatorioMassivaDto;
import br.com.timbrasil.portalcop.gestaoservice.model.Massiva;
import br.com.timbrasil.portalcop.gestaoservice.repository.sql.MassivaSql;

public interface MassivaRepository extends JpaRepository<Massiva, Integer> {
  @Query(name = MassivaSql.GET_MASSIVAS_METALICO, nativeQuery = true)
  List<MassivaDto> getMassivasMetalico();

  @Query(name = MassivaSql.GET_RELATORIO_MASSIVAS_METALICO, nativeQuery = true)
  List<RelatorioMassivaDto> getRelatorioMassivasMetalico(String idMassiva);
}
