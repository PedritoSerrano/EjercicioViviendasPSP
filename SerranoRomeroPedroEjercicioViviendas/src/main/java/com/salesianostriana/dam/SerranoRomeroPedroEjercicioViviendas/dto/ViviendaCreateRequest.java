package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.dto;

import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.EstadoVivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.TipoVivienda;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ViviendaCreateRequest(
        @NotBlank
        @Size(max = 120)
        String titulo,
        @Size(max = 2000)
        String descripcion,
        @NotBlank
        @Size(max = 80)
        String ciudad,
        @NotBlank
        @Size(max = 80)
        String provincia,
        @NotNull
        @Min(0)
        Integer precio,
        @NotNull
        @Min(1)
        Integer metrosCuadrados,
        @NotNull
        @Min(0)
        Integer habitaciones,
        @NotNull
        @Min(0)
        Integer banos,
        @NotNull
        TipoVivienda tipo,
        @NotNull
        EstadoVivienda estado,
        @NotNull
        Boolean ascensor,
        @NotNull
        Boolean terraza,
        @NotNull
        Boolean garaje,
        @NotNull
        Boolean disponible
        ) {}
