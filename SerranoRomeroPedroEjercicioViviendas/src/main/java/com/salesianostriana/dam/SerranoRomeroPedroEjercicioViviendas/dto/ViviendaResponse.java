package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.dto;

import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.EstadoVivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.TipoVivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.Vivienda;

import java.time.LocalDate;

public record ViviendaResponse(
        Long id,
        String titulo,
        String ciudad,
        String provincia,
        Integer precio,
        Integer metrosCuadrados,
        Integer habitaciones,
        Integer banos,
        TipoVivienda tipo,
        EstadoVivienda estado,
        Boolean disponible,
        LocalDate fechaPublicacion
) {

    public static ViviendaResponse of ( Vivienda v){
        return new ViviendaResponse(
                v.getId(),
                v.getTitulo(),
                v.getCiudad(),
                v.getProvincia(),
                v.getPrecio(),
                v.getMetrosCuadrados(),
                v.getHabitaciones(),
                v.getBanos(),
                v.getTipo(),
                v.getEstado(),
                v.getDisponible(),
                v.getFechaPublicacion()
        );
    }

}
