package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.service;

import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.Vivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private ViviendaRepository viviendaRepository;


}
