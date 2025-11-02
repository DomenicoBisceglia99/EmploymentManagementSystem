package com.demo.EMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.EMS.entity.Dipartimento;
import com.demo.EMS.repository.DipartimentoRepository;

@Service
public class DipartimentoService {
	private DipartimentoRepository dipartimentoRepository;
	
	public DipartimentoService(DipartimentoRepository dipartimentoRepository) {
		this.dipartimentoRepository = dipartimentoRepository;
	}
	
	public void deleteDipartimentoById(Long idDipartimento) {
		this.dipartimentoRepository.deleteById(idDipartimento);
	}
	
	public void updateDipartimentoById(Long idDipartimento, Dipartimento nuovoDipartimento) {
		Dipartimento dipartimentoDB = this.dipartimentoRepository.findById(idDipartimento)
				.orElseThrow(()-> new RuntimeException("Dipartimento non trovato con id " + idDipartimento));
		dipartimentoDB.setIndirizzoDipartimento(nuovoDipartimento.getIndirizzoDipartimento());
		dipartimentoDB.setLocalitaDipartimento(nuovoDipartimento.getLocalitaDipartimento());
		dipartimentoDB.setNomeDipartimento(nuovoDipartimento.getNomeDipartimento());
		this.dipartimentoRepository.save(dipartimentoDB);
	}
	
	public void insertDipartimento(Dipartimento nuovoDipartimento) {
		this.dipartimentoRepository.save(nuovoDipartimento);
	}
	
	public Dipartimento getDipartimentoById(Long idDipartimento) {
		return this.dipartimentoRepository.findById(idDipartimento)
				.orElseThrow(()-> new RuntimeException("Dipartimento non trovato con id " + idDipartimento));
	}
	
	public List<Dipartimento> getAllDipartimenti(){
		return this.dipartimentoRepository.findAll();
	}
	
	
	
}
