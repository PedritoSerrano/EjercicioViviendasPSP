package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.controller;

import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.dto.FilterDto;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.dto.ViviendaCreateRequest;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.dto.ViviendaResponse;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.EstadoVivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.TipoVivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.service.ViviendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/viviendas")
public class ViviendaController {

    private final ViviendaService viviendaService;

    @GetMapping
    public ResponseEntity<Page<ViviendaResponse>> filtrarViviendas(@PageableDefault(page = 0,size = 20,sort = "ciudad", direction = Sort.Direction.DESC) Pageable pageable,
                                                   @RequestParam(required = false) String ciudad,
                                                   @RequestParam(required = false) String provincia,
                                                   @RequestParam(required = false) Integer precioMin,
                                                   @RequestParam(required = false) Integer precioMax,
                                                   @RequestParam(required = false) Integer metrosMin,
                                                   @RequestParam(required = false) Integer metrosMax,
                                                   @RequestParam(required = false) Integer habitacionesMin,
                                                   @RequestParam(required = false) Integer banosMin,
                                                   @RequestParam(required = false) TipoVivienda tipo,
                                                   @RequestParam(required = false) EstadoVivienda estado,
                                                   @RequestParam(required = false) Boolean ascensor,
                                                   @RequestParam(required = false) Boolean terraza,
                                                   @RequestParam(required = false) Boolean garaje,
                                                   @RequestParam(required = false) Boolean soloDisponibles
                                                   ){
        FilterDto dto = new FilterDto(
                ciudad,
                provincia,
                precioMin,
                precioMax,
                metrosMin,
                metrosMax,
                habitacionesMin,
                banosMin,
                tipo,
                estado,
                ascensor,
                terraza,
                garaje,
                soloDisponibles
        );

        Page<ViviendaResponse> result = viviendaService.filtrarViviendas(dto, pageable).map(ViviendaResponse::of);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ViviendaResponse> create (@Valid @RequestBody ViviendaCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(ViviendaResponse.of(viviendaService.create(request)));
    }

}
