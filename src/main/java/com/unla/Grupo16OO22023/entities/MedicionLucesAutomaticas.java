package com.unla.Grupo16OO22023.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private LocalDateTime fechaHora;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updateat")
	@UpdateTimestamp
	private LocalDateTime updateAt;


	public MedicionLucesAutomaticas(long idMedicionLucesAutomaticas, boolean hayPersonas, LocalDateTime fechaHora) {
		super();
		this.idMedicionLucesAutomaticas = idMedicionLucesAutomaticas;
		this.hayPersonas = hayPersonas;
		this.fechaHora = fechaHora;
	}

}
