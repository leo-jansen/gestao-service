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
@Table(name = "cop_app_metal_tp_acao", schema = "cicop")
public class Acao {
	@Id
	@Column(name = "id_tp_acao")
	private int id;
	@Column(name = "desc_tp_acao")
	private String descAcao;
}
