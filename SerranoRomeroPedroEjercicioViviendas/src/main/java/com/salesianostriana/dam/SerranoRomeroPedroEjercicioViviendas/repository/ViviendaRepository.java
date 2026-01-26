package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.repository;

import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.Vivienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ViviendaRepository extends JpaRepository<Vivienda, Long>, JpaSpecificationExecutor<Vivienda> {
}
