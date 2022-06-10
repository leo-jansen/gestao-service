package br.com.timbrasil.portalcop.gestaoservice.model;

import java.time.LocalDateTime;

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
@Table(name = "cop_app_metal_massiva_msg", schema = "cicop")
public class MassivaMetalicaMsg {
  @Id
  @Column(name = "msg_id")
  @SequenceGenerator(name = "TB_METAL_MASSIVA_MSG_ID_GENERATOR", sequenceName = "SQ_COP_APP_METAL_MASIVA_MSG", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_METAL_MASSIVA_MSG_ID_GENERATOR")
  private Long msgId;
  @Column(name = "dt_acao")
  private LocalDateTime dataAcao;
  @Column(name = "id_massiva")
  private String idMassiva;
  @Column(name = "usuario")
  private String usuario;
  @Column(name = "acao_exec")
  private String acaoExec;

  public MassivaMetalicaMsg(LocalDateTime dataAcao, String idMassiva, String usuario, String acaoExec) {
    this.dataAcao = dataAcao;
    this.idMassiva = idMassiva;
    this.usuario = usuario;
    this.acaoExec = acaoExec;
  }
}
