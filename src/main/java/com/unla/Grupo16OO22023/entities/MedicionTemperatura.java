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
@Table(name="medicionTemperatura")
public class MedicionTemperatura {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMedicionTemperatura;
	
	@Column
	private int temperatura;
	
	@Column
	private LocalDateTime fechaHora;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updateat")
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	@ManyToOne
	@JoinColumn(name = "dispositivoTemperaturaId") 
	private DispositivoTemperatura dispositivoTemperatura;

	@Column(name="procesado")
	private boolean procesado;

	public MedicionTemperatura(long idMedicionTemperatura, int temperatura, LocalDateTime fechaHora, DispositivoTemperatura dispositivoTemperatura, boolean procesado) {
		super();
		this.idMedicionTemperatura = idMedicionTemperatura;
		this.temperatura = temperatura;
		this.fechaHora = fechaHora;
		this.dispositivoTemperatura = dispositivoTemperatura;
		this.procesado = procesado;
	}
	
	
	
}
