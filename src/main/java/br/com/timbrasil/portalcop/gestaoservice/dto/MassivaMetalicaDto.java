package br.com.timbrasil.portalcop.gestaoservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.timbrasil.portalcop.gestaoservice.model.MassivaMetalica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MassivaMetalicaDto {
  private String id;
  private String idMassiva;
  private int idAcao;
  private String descAcao;
  private String dataAbertura;
  private String tipo;
  private int status;
  private String msan;
  private String parInicio;
  private String parFim;
  private String uf;
  private String cidade;
  private int idFalha;
  private String descFalha;
  private int idArea;
  private String descArea;
  private LocalDateTime prazo;
  private String expirado;
  private String empreiteira;
  private int qtdClientes;
  private String dataInicioIndisponibilidade;
  private String dataFimIndisponibilidade;
  private int indisponibilidade;
  private String observacao;

  public static List<MassivaMetalicaDto> converter(List<MassivaMetalica> metalicas) {
    return metalicas.stream().map(m -> MassivaMetalicaDto.converter(m)).toList();
  }

  public static MassivaMetalicaDto converter(MassivaMetalica metalica) {
    return new MassivaMetalicaDto(metalica.getId(), metalica.getIdMassiva(),
      metalica.getIdAcao(), metalica.getDescAcao(),
      metalica.getDataAbertura(), metalica.getTipo(), 
      metalica.getStatus(), metalica.getMsan(), 
      metalica.getParInicio(), metalica.getParFim(), metalica.getUf(), 
      metalica.getCidade(), metalica.getIdFalha(), metalica.getDescFalha(), metalica.getIdArea(),
      metalica.getDescArea(), metalica.getPrazo(), metalica.getExpirado(), metalica.getEmpreiteira(), 
      metalica.getQtdClientes(), metalica.getDataInicioIndisponibilidade(), 
      metalica.getDataFimIndisponibilidade(), metalica.getIndisponibilidade(), metalica.getObservacao());
  }
}
