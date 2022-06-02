package br.com.timbrasil.portalcop.gestaoservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cop_app_metal_empreiteiras", schema = "cicop")
public class Empreiteira {
  @Id
  @SequenceGenerator(name = "sq_empreiteira", sequenceName = "sq_empreiteira", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_empreiteira")
  private int id;
  @Column(name = "nome_empreiteira")
  private String nomeEmpreiteira;
  @Column(name = "empreiteira_ativa")
  private int empreiteiraAtiva;
}
