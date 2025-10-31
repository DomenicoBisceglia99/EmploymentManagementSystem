package com.demo.EMS.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Ruolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRuolo;
	
	private TipoRuolo tipoRuolo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dipendente")
	private Dipendente dipendente;

	public Ruolo() {}
	public Ruolo(TipoRuolo tipoRuolo) {
		this.tipoRuolo = tipoRuolo;
	}
	
	public Long getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}

	public TipoRuolo getTipoRuolo() {
		return tipoRuolo;
	}

	public void setTipoRuolo(TipoRuolo tipoRuolo) {
		this.tipoRuolo = tipoRuolo;
	}
	
	
	
}
