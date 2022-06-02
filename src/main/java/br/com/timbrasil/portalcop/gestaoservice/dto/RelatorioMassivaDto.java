package br.com.timbrasil.portalcop.gestaoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioMassivaDto {
  private String idMassiva;
  private String serviceId;
  private String mdf;
  private String caixa;
  private String par;
}
