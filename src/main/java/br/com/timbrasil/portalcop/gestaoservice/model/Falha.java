package br.com.timbrasil.portalcop.gestaoservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cop_app_metal_tp_falha", schema = "cicop")
public class Falha {
  @Id
	@Column(name = "id_tp_falha")
	private int id;

	@Column(name = "desc_tp_falha")
	private String descFalha;
}
