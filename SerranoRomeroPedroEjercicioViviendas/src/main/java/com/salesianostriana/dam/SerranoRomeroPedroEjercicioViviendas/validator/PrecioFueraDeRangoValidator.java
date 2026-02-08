package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrecioFueraDeRangoValidator implements ConstraintValidator<PrecioFueraDeRango, Integer> {

    private int precioMax;

    @Override
    public void initialize(PrecioFueraDeRango constraintAnnotation) {
        this.precioMax = constraintAnnotation.precioMax();
    }

    @Override
    public boolean isValid(Integer valor, ConstraintValidatorContext constraintValidatorContext) {
        if (valor == null) {
            return true;
        }
        return valor > 0 && valor <= precioMax;
    }
}
