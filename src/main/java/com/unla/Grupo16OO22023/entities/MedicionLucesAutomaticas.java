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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="medicionLucesAutomaticas")
public class MedicionLucesAutomaticas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMedicionLucesAutomaticas;
	
	@Column
	private boolean hayPersonas;
	
	@Column
	private boolean hayLuzNatural;
	
	@ManyToOne
	@JoinColumn(name = "dispositivoLucesAutomaticasId")
	private DispositivoLucesAutomaticas dispositivoLucesAutomaticas;
	
	@Column
	private LocalDateTime fechaHora;
	
	@Column
	private boolean lucesPrendidas;
	
	@Column
	private boolean procesado;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updateat")
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public MedicionLucesAutomaticas(long idMedicionLucesAutomaticas, boolean hayPersonas, boolean hayLuzNatural,
			DispositivoLucesAutomaticas dispositivoLucesAutomaticas, LocalDateTime fechaHora, boolean lucesPrendidas,
			boolean procesado) {
		super();
		this.idMedicionLucesAutomaticas = idMedicionLucesAutomaticas;
		this.hayPersonas = hayPersonas;
		this.hayLuzNatural = hayLuzNatural;
		this.dispositivoLucesAutomaticas = dispositivoLucesAutomaticas;
		this.fechaHora = fechaHora;
		this.lucesPrendidas = lucesPrendidas;
		this.procesado = procesado;
	}





}
