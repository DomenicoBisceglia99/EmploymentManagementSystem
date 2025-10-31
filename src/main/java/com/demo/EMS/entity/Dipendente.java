package com.demo.EMS.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Dipendente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDipendente;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(length = 16, nullable = false, unique = true)
	private String codiceFiscale;
	@Column(nullable = false)
	private Date dataNascita;
	@Column(nullable = false)
	private Date dataAssunzione;
	@Column(nullable = false, unique = true)
	private String telefono;
	@Column(nullable = false, unique = true)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_dipartimento")
	private Dipartimento dipartimento;
	
	@OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL)
	private List<ArchivioDocumenti> archivioDocumenti;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_user")
	private User user;
	
	@OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL)
	private List<Ruolo> ruolo;
	
	@OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Presenze> presenze;
	
    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL)
	private List<ArchivioSalari> archivioSalari;

    public Dipendente() {}
    
    public Dipendente (String nome, String cognome, String codiceFiscale, Date dataNascita, String telefono, String email) {
    	this.nome = nome;
    	this.cognome = cognome;
    	this.codiceFiscale = codiceFiscale;
    	this.dataNascita = dataNascita;
    	this.telefono = telefono;
    	this.email = email;
    }
    
	public Long getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(Long idDipendente) {
		this.idDipendente = idDipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public List<ArchivioDocumenti> getArchivioDocumenti() {
		return archivioDocumenti;
	}

	public void setArchivioDocumenti(List<ArchivioDocumenti> archivioDocumenti) {
		this.archivioDocumenti = archivioDocumenti;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public List<Ruolo> getRuolo() {
		return ruolo;
	}

	public void setRuolo(List<Ruolo> ruolo) {
		this.ruolo = ruolo;
	}

	public List<Presenze> getPresenze() {
		return presenze;
	}

	public void setPresenze(List<Presenze> presenze) {
		this.presenze = presenze;
	}

	public List<ArchivioSalari> getArchivioSalari() {
		return archivioSalari;
	}

	public void setArchivioSalari(List<ArchivioSalari> archivioSalari) {
		this.archivioSalari = archivioSalari;
	}
	
    
    
}
