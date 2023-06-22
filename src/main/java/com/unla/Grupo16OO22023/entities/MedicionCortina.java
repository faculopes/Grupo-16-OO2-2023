package com.unla.Grupo16OO22023.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name="medicionCortina")
public class MedicionCortina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMedicionCortina;
	
	@Column
	private LocalDateTime fechaHora;
	
	@Column
	private LocalTime hora;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updateat")
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	@ManyToOne
	@JoinColumn(name = "dispositivoCortinaId") 
	private DispositivoCortina dispositivoCortina;
	
	@Column(name="procesado")
	private boolean procesado;

	public MedicionCortina(long idMedicionCortina, LocalDateTime fechaHora, LocalTime hora, LocalDateTime createdAt,
			LocalDateTime updateAt, DispositivoCortina dispositivoCortina, boolean procesado) {
		super();
		this.idMedicionCortina = idMedicionCortina;
		this.fechaHora = fechaHora;
		this.hora = hora;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.dispositivoCortina = dispositivoCortina;
		this.procesado = procesado;
	}

	

	
	

}
