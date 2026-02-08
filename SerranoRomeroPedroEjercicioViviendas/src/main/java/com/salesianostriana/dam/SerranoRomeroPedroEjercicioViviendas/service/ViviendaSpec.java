package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.service;

import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.EstadoVivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.TipoVivienda;
import com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.model.Vivienda;
import org.springframework.data.jpa.domain.PredicateSpecification;

public interface ViviendaSpec {

    public static PredicateSpecification<Vivienda> filtrarPorCiudad (String ciudad){
        return (from, cb) ->
               ciudad == null
                    ? cb.and()
                    : cb.like(cb.lower(from.get("ciudad")), "%" + ciudad.toLowerCase() + "%");
    }

    public static PredicateSpecification<Vivienda> filtrarPorProvincia (String provincia){
        return (from, cb) ->
                provincia == null
                        ? cb.and()
                        : cb.equal(cb.lower(from.get("provincia")),provincia.toLowerCase());
    }

    public static PredicateSpecification<Vivienda> filtrarPorPrecio (Integer precioMin, Integer precioMax){
        return (from, cb) -> {

            Integer precio_min = (precioMin == null) ? 0 : precioMin;
            Integer precio_max = (precioMax == null) ? Integer.MAX_VALUE : precioMax;

            return cb.between(from.get("precio"), precio_min, precio_max);
        };
    }

    public static PredicateSpecification<Vivienda> filtrarPorMetros (Integer metrosMin, Integer metrosMax){
        return (from, cb) -> {

            Integer metros_min = (metrosMin == null) ? 0 : metrosMin;
            Integer metros_max = (metrosMax == null) ? Integer.MAX_VALUE : metrosMax;

            return cb.between(from.get("metrosCuadrados"), metros_min, metros_max);
        };
    }

    public static PredicateSpecification<Vivienda> filtrarPorHabitaciones (Integer habitacionesMin){
        return (from, cb) ->
            habitacionesMin == null
                    ? cb.and()
                    : cb.greaterThanOrEqualTo(from.get("habitaciones"), habitacionesMin);
    }

    public static PredicateSpecification<Vivienda> filtrarPorBanos (Integer banosMin){
        return (from, cb) ->
            banosMin == null
                    ? cb.and()
                    : cb.greaterThanOrEqualTo(from.get("banos"), banosMin);
    }

    public static PredicateSpecification<Vivienda> filtrarPorTipo (TipoVivienda tipo) {
        return (from, cb) ->
            tipo == null
                    ? cb.and()
                    : cb.equal(from.get("tipo"), tipo);
    }

    public static PredicateSpecification<Vivienda> filtrarPorEstado (EstadoVivienda estado) {
        return (from, cb) ->
                estado == null
                        ? cb.and()
                        : cb.equal(from.get("estado"), estado);
    }

    public static PredicateSpecification<Vivienda> filtrarPorAscensor (Boolean ascensor) {
        return (from, cb) ->
                ascensor == null
                        ? cb.and()
                        : cb.equal(from.get("ascensor"), ascensor);
    }

    public static PredicateSpecification<Vivienda> filtrarPorTerraza (Boolean terraza) {
        return (from, cb) ->
                terraza == null
                        ? cb.and()
                        : cb.equal(from.get("terraza"), terraza);
    }

    public static PredicateSpecification<Vivienda> filtrarPorGaraje (Boolean garaje) {
        return (from, cb) ->
                garaje == null
                        ? cb.and()
                        : cb.equal(from.get("garaje"), garaje);
    }

    public static PredicateSpecification<Vivienda> filtrarSoloDisponibles (Boolean soloDisponibles) {
        return (from, cb) ->
                soloDisponibles == null || !soloDisponibles
                        ? cb.and()
                        : cb.equal(from.get("estado"), soloDisponibles);
    }
}
