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
@Table(name="medicionAlumbrado")
public class MedicionAlumbrado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMedicionAlumbrado;
	
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

	public MedicionAlumbrado(long idMedicionAlumbrado, boolean hayPersonas, LocalDateTime fechaHora) {
		super();
		this.idMedicionAlumbrado = idMedicionAlumbrado;
		this.hayPersonas = hayPersonas;
		this.fechaHora = fechaHora;
	}

}
