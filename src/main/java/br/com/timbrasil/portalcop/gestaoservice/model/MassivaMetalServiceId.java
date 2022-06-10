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
@Table(name = "cop_app_metal_mass_serviceid", schema = "cicop")
public class MassivaMetalServiceId {
  @Id
  @SequenceGenerator(name = "TB_METAL_MASS_SERVICEID_ID_GENERATOR", sequenceName = "SQ_APP_METAL_MASS_SERVICEID", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_METAL_MASS_SERVICEID_ID_GENERATOR")
  private long id;
  @Column(name = "fk_metal_massiva", nullable = false)
  private long fkMetalMassiva;
  @Column(name = "serviceid", nullable = false)
  private String serviceid;
  @Column(name = "nrm_mdf")
  private String nrmMdf;
  @Column(name = "sgf_caixa")
  private String sgfCaixa;
  @Column(name = "sgf_par")
  private String sgfPar;
  @Column(name = "bss_status_banda_larga")
  private String bssStatusBandaLarga;
}
