package com.demo.EMS.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.demo.EMS.entity.Dipendente;
import com.demo.EMS.entity.TipoRuolo;
import com.demo.EMS.repository.DipendenteRepository;

@Service
public class DipendenteService {
	
	private DipendenteRepository dipendenteRepository;
	
	public DipendenteService(DipendenteRepository dipendenteRepository) {
		this.dipendenteRepository = dipendenteRepository;
	}
	
	public List<Dipendente> getAllDipendenti() {
		return this.dipendenteRepository.findAll();
	}
	
	public void deleteDipendenteByID(Long idDipendente) {
		this.dipendenteRepository.deleteById(idDipendente);
	}
	
	public List<Dipendente> searchDipendenti(String keyword) {
		return this.dipendenteRepository.searchDipendenti(keyword);
	}
	
	public List<Dipendente> searchWithFilters(String keyword, TipoRuolo ruolo, Long dipartimentoId) {
		return this.dipendenteRepository.searchWithFilters(keyword, ruolo, dipartimentoId);
	}
	
	public List<TipoRuolo> getAllRuoli() {
		return this.dipendenteRepository.findAllDistinctRuoli();
	}
}