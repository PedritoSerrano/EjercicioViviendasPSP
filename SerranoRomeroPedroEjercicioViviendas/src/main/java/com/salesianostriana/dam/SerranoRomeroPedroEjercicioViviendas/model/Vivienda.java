package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.time.LocalDate;
import java.util.Objects;

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

    private String titulo;
    private String descripcion;
    private String ciudad;
    private String provincia;
    private Integer precio;
    private Integer metrosCuadrados;
    private Integer habitaciones;
    private Integer banos;
    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;
    @Enumerated(EnumType.STRING)
    private EstadoVivienda estado;
    private Boolean ascensor;
    private Boolean terraza;
    private Boolean garaje;
    private Boolean disponible;
    private LocalDate fechaPublicacion;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Vivienda vivienda = (Vivienda) o;
        return getId() != null && Objects.equals(getId(), vivienda.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public static interface Specs {

        public static PredicateSpecification<Vivienda> saldoBetween (Double min, Double max) {
            return (from, cb) ->{
                    Double realMin = (min != null) ? min : Double.NEGATIVE_INFINITY;
                    Double realMax = (max != null) ? max : Double.POSITIVE_INFINITY;

                    return cb.between(from.get("precioMin"), realMin, realMax);
            };
        }

    }

}
