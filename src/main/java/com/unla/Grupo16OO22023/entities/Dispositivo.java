package com.unla.Grupo16OO22023.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="dispositivo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long idDispositivo;
	
	@Column
	protected String nombre;
	
	
	@ManyToOne
	@JoinColumn(name = "idZona")
	protected Zona zona;
	
	@Column
	protected boolean activo;
	
	@Column
	protected boolean baja;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updateat")
	@UpdateTimestamp
	private LocalDateTime updateAt;


	public Dispositivo(long idDispositivo, String nombre, Zona zona, boolean activo, boolean baja) {
		super();
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.zona = zona;
		this.activo = activo;
		this.baja = baja;
	}


	public Dispositivo(String nombre, Zona zona, boolean activo, boolean baja) {
		super();
		this.nombre = nombre;
		this.zona = zona;
		this.activo = activo;
		this.baja = baja;
	}
	
	

}
