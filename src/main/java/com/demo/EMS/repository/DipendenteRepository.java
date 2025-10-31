package com.demo.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.EMS.entity.Dipendente;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {

}
