package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.dto;

import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.EstadoVivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.TipoVivienda;

public record FilterDto(
            String ciudad,
            String provincia,
            Integer precioMin,
            Integer precioMax,
            Integer metrosMin,
            Integer metrosMax,
            Integer habitacionesMin,
            Integer banosMin,
            TipoVivienda tipo,
            EstadoVivienda estado,
            Boolean ascensor,
            Boolean terraza,
            Boolean garaje,
            Boolean soloDisponibles
) {
}
