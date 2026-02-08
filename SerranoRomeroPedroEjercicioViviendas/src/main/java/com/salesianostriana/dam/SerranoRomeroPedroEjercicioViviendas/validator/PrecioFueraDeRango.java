package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrecioFueraDeRangoValidator.class)
@Documented
public @interface PrecioFueraDeRango {

    String message() default "Precio fuera de rango";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int precioMax();
}
