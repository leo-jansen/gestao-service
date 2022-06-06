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
@Table(name = "cop_app_uf_cidade", schema = "cicop")
public class UfCidade {
  @Id
  @SequenceGenerator(name = "uf", sequenceName = "sq_uf", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uf")
  private int id;
  private String uf;
  private String cidade;
  @Column(name = "msan_cod")
  private String msanCod;
}
