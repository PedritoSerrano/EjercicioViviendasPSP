package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "viviendas")
public class Vivienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    @NotBlank(message = "La ciudad no puede estar vacía")
    private String ciudad;
    @NotBlank(message = "La provincia no puede estar vacía")
    private String provincia;
    @Min(0)
    private Integer precio;
    @Min(1)
    private Integer metrosCuadrados;
    @Min(0)
    private Integer habitaciones;
    @Min(0)
    private Integer banos;
    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;
    @Enumerated(EnumType.STRING)
    private EstadoVivienda estado;
    @Basic(optional = false)
    private Boolean ascensor;
    @Basic(optional = false)
    private Boolean terraza;
    @Basic(optional = false)
    private Boolean garaje;
    @Basic(optional = false)
    private Boolean disponible;
    @Column(nullable = false)
    private LocalDate fechaPublicacion;

}
