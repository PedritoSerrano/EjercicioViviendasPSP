package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.service;

import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.dto.FilterDto;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.dto.ViviendaCreateRequest;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.Vivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    public Page<Vivienda> filtrarViviendas (FilterDto dto, Pageable pageable) {
        return viviendaRepository.findBy(
                PredicateSpecification.allOf(
                    ViviendaSpec.filtrarPorCiudad(dto.ciudad()),
                    ViviendaSpec.filtrarPorProvincia(dto.provincia()),
                    ViviendaSpec.filtrarPorPrecio(dto.precioMin(), dto.precioMax()),
                    ViviendaSpec.filtrarPorMetros(dto.metrosMin(), dto.metrosMax()),
                    ViviendaSpec.filtrarPorHabitaciones(dto.habitacionesMin()),
                    ViviendaSpec.filtrarPorBanos(dto.banosMin()),
                    ViviendaSpec.filtrarPorTipo(dto.tipo()),
                    ViviendaSpec.filtrarPorEstado(dto.estado()),
                    ViviendaSpec.filtrarPorAscensor(dto.ascensor()),
                    ViviendaSpec.filtrarPorTerraza(dto.terraza()),
                    ViviendaSpec.filtrarPorGaraje(dto.garaje()),
                    ViviendaSpec.filtrarSoloDisponibles(dto.soloDisponibles())
                ), q -> q.page(pageable)
        );
    }

    public Vivienda create (ViviendaCreateRequest request) {
        Vivienda v = Vivienda.builder()
                .titulo(request.titulo())
                .descripcion(request.descripcion())
                .ciudad(request.ciudad())
                .provincia(request.provincia())
                .precio(request.precio())
                .metrosCuadrados(request.metrosCuadrados())
                .habitaciones(request.habitaciones())
                .banos(request.banos())
                .tipo(request.tipo())
                .estado(request.estado())
                .ascensor(request.ascensor())
                .terraza(request.terraza())
                .garaje(request.garaje())
                .build();

        return  viviendaRepository.save(v);
    }
}