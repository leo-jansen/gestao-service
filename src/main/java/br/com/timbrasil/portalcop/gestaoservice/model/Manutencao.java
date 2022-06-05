package br.com.timbrasil.portalcop.gestaoservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cop_app_tp_manutencao", schema = "cicop")
public class Manutencao {
  @Id
  @Column(name = "id_tp_manutencao")
  @SequenceGenerator(name = "manutencao", sequenceName = "sq_tp_manutencao", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manutencao")
  private int id;
  @Column(name = "desc_tp_manutencao")
  private String descManutencao;
  @Column(name = "id_tp_acao")
  private int idAcao;
  @Column(name = "flag_indisponibilidade")
  private boolean flagIndisponibilidade;
  @Column(name = "minutos_indisponibilidade")
  private int minutosIndisponibilidade;
  @Column(name = "minuto_atividade")
  private int minutoAtividade;
  @Column(name = "flag_ativo")
  private boolean flagAtivo;

  public Manutencao(String descManutencao, int idAcao) {
    this.descManutencao = descManutencao;
    this.idAcao = idAcao;
    this.flagIndisponibilidade = false;
    this.minutosIndisponibilidade = 0;
    this.minutoAtividade = 0;
    this.flagAtivo = true;
  }
}
