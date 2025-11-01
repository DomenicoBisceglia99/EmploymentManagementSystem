package com.demo.EMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.EMS.entity.Dipendente;
import com.demo.EMS.repository.DipendenteRepository;

@Service
public class DipendenteService {
	private DipendenteRepository dipendenteRepository;
	
	public DipendenteService(DipendenteRepository dipendenteRepository) {
		this.dipendenteRepository = dipendenteRepository;
	}
	
	public void deleteDipendenteByID(Long idDipendente) {
		this.dipendenteRepository.deleteById(idDipendente);
	}
	
	public void updateDipendenteById(Long idDipendente, Dipendente nuovoDipendente) {
		Dipendente dipendenteDB = this.dipendenteRepository.findById(idDipendente)
				.orElseThrow(() -> new RuntimeException("Dipendente non trovato con id " + idDipendente));
		dipendenteDB.setCodiceFiscale(nuovoDipendente.getCodiceFiscale());
		dipendenteDB.setCognome(nuovoDipendente.getCognome());
		dipendenteDB.setDataAssunzione(nuovoDipendente.getDataAssunzione());
		dipendenteDB.setDataNascita(nuovoDipendente.getDataNascita());
		dipendenteDB.setEmail(nuovoDipendente.getEmail());
		dipendenteDB.setNome(nuovoDipendente.getNome());
		dipendenteDB.setTelefono(nuovoDipendente.getTelefono());
		dipendenteDB.setDipartimento(nuovoDipendente.getDipartimento());
		this.dipendenteRepository.save(dipendenteDB);
	}
	
	public void insertDipendente(Dipendente nuovoDipendente) {
		this.dipendenteRepository.save(nuovoDipendente);
	}
	
	public Dipendente getDipendenteById(Long idDipendente) {
		return this.dipendenteRepository.findById(idDipendente)
				.orElseThrow(() -> new RuntimeException("Dipendente non trovato con id " + idDipendente));
	}
	
	public List<Dipendente> getAllDipendenti(){
		return this.dipendenteRepository.findAll();
	}
	
}
