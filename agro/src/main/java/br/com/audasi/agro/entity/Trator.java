package br.com.audasi.agro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "trator")
public class Trator {
	
	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtrator", unique = true)
	protected long id;

	@Column(name = "modelo", nullable = false, length = 120)
	private String modelo;
	

	@Column(name = "marca", nullable = false, length = 120)
	private String marca;
	
}
