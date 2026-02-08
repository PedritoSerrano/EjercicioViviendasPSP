package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MetrosCuadradosFueraDeRangoValidator.class)
@Documented
public @interface MetrosFueraDeRango {

    String message() default "Metros cuadrados fuera de rango";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int metrosCuadradosMax();

}
