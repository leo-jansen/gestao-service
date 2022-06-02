package br.com.timbrasil.portalcop.gestaoservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cop_app_uf_cidade", schema = "cicop")
public class UfCidade {
  @Id
  @SequenceGenerator(name = "sq_uf", sequenceName = "sq_uf", allocationSize = 1)
  private int id;
  private String uf;
  private String cidade;
  @Column(name = "msan_cod")
  private String msanCod;
}
