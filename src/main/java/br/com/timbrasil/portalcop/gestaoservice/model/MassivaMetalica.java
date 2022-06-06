package br.com.timbrasil.portalcop.gestaoservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "vw_massiva_metalica_portal", schema = "cicop")
public class MassivaMetalica {
  @Id
  @Column(name = "ID")
  private String id;
  @Column(name = "ID_MASSIVA")
  private String idMassiva;
  @Column(name = "ID_TP_ACAO")
  private int idAcao;
  @Column(name = "DESC_TP_ACAO")
  private String descAcao;
  @Column(name = "DT_ABERTURA")
  private String dataAbertura;
  @Column(name = "TIPO")
  private String tipo;
  @Column(name = "STATUS")
  private int status;
  @Column(name = "MSAN")
  private String msan;
  @Column(name = "PAR_INI")
  private String parInicio;
  @Column(name = "PAR_FIM")
  private String parFim;
  @Column(name = "UF")
  private String uf;
  @Column(name = "CIDADE")
  private String cidade;
  @Column(name = "ID_TP_FALHA")
  private int idFalha;
  @Column(name = "DESC_TP_FALHA")
  private String descFalha;
  @Column(name = "ID_AREA")
  private int idArea;
  @Column(name = "DESC_AREA")
  private String descArea;
  @Column(name = "PRAZO")
  private LocalDateTime prazo;
  @Column(name = "EXPIRADO")
  private String expirado;
  @Column(name = "EMPREITEIRA")
  private String empreiteira;
  @Column(name = "QTD_CLIENTES")
  private int qtdClientes;
  @Column(name = "DT_INI_INDISPONIBILIDADE")
  private String dataInicioIndisponibilidade;
  @Column(name = "DT_FIM_INDISPONIBILIDADE")
  private String dataFimIndisponibilidade;
  @Column(name = "INDISPONIBILIDADE")
  private int indisponibilidade;
  @Column(name = "OBSERVACAO")
  private String observacao;  
}
