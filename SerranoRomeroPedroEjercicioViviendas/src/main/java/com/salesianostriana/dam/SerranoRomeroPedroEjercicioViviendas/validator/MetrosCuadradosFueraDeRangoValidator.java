package com.salesianostriana.dam.SerranoRomeroPedroEjercicioViviendas.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MetrosCuadradosFueraDeRangoValidator implements ConstraintValidator<MetrosFueraDeRango, Integer> {

    private int metrosCuadradosMax;

    @Override
    public void initialize(MetrosFueraDeRango constraintAnnotation) {
        this.metrosCuadradosMax = constraintAnnotation.metrosCuadradosMax();
    }

    @Override
    public boolean isValid(Integer valor, ConstraintValidatorContext constraintValidatorContext) {
        if (valor == null) {
            return true;
        }
        return valor > 0 && valor <= metrosCuadradosMax;
    }
}
