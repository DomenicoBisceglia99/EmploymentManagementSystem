package com.demo.EMS.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Dipartimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDipartimento;
	@Column(nullable = false)
	private String nomeDipartimento;
	@Column(nullable = false)
	private String localitaDipartimento;
	@Column(nullable = false)
	private String indirizzoDipartimento;
	@OneToMany(mappedBy = "dipartimento", fetch = FetchType.LAZY)
	private List<Dipendente> dipendenti;
	
	public Dipartimento() {}
	public Dipartimento(String nomeDipartimento, String localitaDipartimento, String indirizzoDipartimento) {
		this.nomeDipartimento = nomeDipartimento;
		this.localitaDipartimento = localitaDipartimento;
		this.indirizzoDipartimento = indirizzoDipartimento;
	}
	
	
	public Long getIdDipartimento() {
		return idDipartimento;
	}
	public void setIdDipartimento(Long idDipartimento) {
		this.idDipartimento = idDipartimento;
	}
	public String getNomeDipartimento() {
		return nomeDipartimento;
	}
	public void setNomeDipartimento(String nomeDipartimento) {
		this.nomeDipartimento = nomeDipartimento;
	}
	public String getLocalitaDipartimento() {
		return localitaDipartimento;
	}
	public void setLocalitaDipartimento(String localitaDipartimento) {
		this.localitaDipartimento = localitaDipartimento;
	}
	public String getIndirizzoDipartimento() {
		return indirizzoDipartimento;
	}
	public void setIndirizzoDipartimento(String indirizzoDipartimento) {
		this.indirizzoDipartimento = indirizzoDipartimento;
	}
	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}
	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	
}
