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
@Table(name="medicionTemperatura")
public class MedicionTemperatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMedicionTemperatura;
	
	@Column
	private boolean tempAlta;
	
	@Column
	private LocalDateTime fechaHora;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updateat")
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public MedicionTemperatura(long idMedicionTemperatura, boolean tempAlta, LocalDateTime fechaHora) {
		super();
		this.idMedicionTemperatura = idMedicionTemperatura;
		this.tempAlta = tempAlta;
		this.fechaHora = fechaHora;
	}

}
