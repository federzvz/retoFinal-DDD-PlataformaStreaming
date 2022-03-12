package co.com.sofka.domain.funcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class FechaInicio implements ValueObject<LocalDate> {
    private final LocalDate value;

    public FechaInicio() {
        this.value=LocalDate.now();
    }

    public FechaInicio(LocalDate value) {
        LocalDate today = LocalDate.now();
        this.value = Objects.requireNonNull(value);
        if(value.isBefore(today)){
            throw new IllegalArgumentException("La fecha ingresada ya es una fecha pasada.");
        }
    }

    @Override
    public LocalDate value() {
        return value;
    }
}
