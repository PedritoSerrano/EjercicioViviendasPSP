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

    @Column(nullable = false)
    private String titulo;

    private String descripcion;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private Integer precio;

    @Column(nullable = false, name = "metros_cuadrados")
    private Integer metrosCuadrados;

    @Column(nullable = false)
    private Integer habitaciones;

    @Column(nullable = false)
    private Integer banos;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoVivienda estado;

    @Column(nullable = false)
    private Boolean ascensor;

    @Column(nullable = false)
    private Boolean terraza;

    @Column(nullable = false)
    private Boolean garaje;

    @Column(nullable = false)
    private Boolean disponible;

    @Column(nullable = false, name = "fecha_publicacion")
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
}
