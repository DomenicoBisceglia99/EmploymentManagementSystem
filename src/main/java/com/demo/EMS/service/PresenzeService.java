package com.demo.EMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.EMS.entity.Presenze;
import com.demo.EMS.repository.PresenzeRepository;

@Service
public class PresenzeService {
	private PresenzeRepository presenzeRepository;
	
	public PresenzeService(PresenzeRepository presenzeRepository) {
		this.presenzeRepository = presenzeRepository;
	}
	
	public void deletePresenzaById(Long idPresenza) {
		this.presenzeRepository.deleteById(idPresenza);
	}
	
	public void updatePresenza(Long idPresenza, Presenze nuovaPresenza) {
		Presenze presenzaDB = this.presenzeRepository.findById(idPresenza)
				.orElseThrow(()-> new RuntimeException("Presenza non trovata con id " + idPresenza));
		presenzaDB.setDataFineTurno(nuovaPresenza.getDataFineTurno());
		presenzaDB.setDataInizioTurno(nuovaPresenza.getDataInizioTurno());
		this.presenzeRepository.save(presenzaDB);
	}
	
	public void insertPresenza(Presenze nuovaPresenza) {
		this.presenzeRepository.save(nuovaPresenza);
	}
	
	public Presenze getPresenzaById(Long idPresenza) {
		return this.presenzeRepository.findById(idPresenza)
				.orElseThrow(()-> new RuntimeException("Presenza non trovata con id " + idPresenza));
	}
	
	public List<Presenze> getAllPresenze(){
		return this.presenzeRepository.findAll();
	}
	
}
