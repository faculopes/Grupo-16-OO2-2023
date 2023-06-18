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
@Table(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEvento;
	
	@Column
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idDispositivo")
	private Dispositivo dispositivo;
	
	@Column
	private LocalDateTime fechaHora;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updateat")
	@UpdateTimestamp
	private LocalDateTime updateAt;


	public Evento(long idEvento, String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) {
		super();
		this.idEvento = idEvento;
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
		this.fechaHora = fechaHora;
	}

}
