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
@Table(name = "cop_app_metal_area", schema = "cicop")
public class Area {
  @Id
  @Column(name = "id_area")
  @SequenceGenerator(name = "area", sequenceName = "sq_area", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area")
	private int id;
	@Column(name = "desc_area")
	private String descArea;
}
