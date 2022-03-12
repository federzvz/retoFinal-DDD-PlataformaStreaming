package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaRegistro implements ValueObject<LocalDate> {
    private final LocalDate value;

    public FechaRegistro() {
        this(LocalDate.now());
    }

    public FechaRegistro(LocalDate value) {
        LocalDate today = LocalDate.now();
        this.value = Objects.requireNonNull(value);
        if(value.isBefore(value)){
            throw new IllegalArgumentException("Inconsistencia de fechas, la fecha de registro debe ser la actual.");
        }
    }

    @Override
    public LocalDate value() {
        return value;
    }
}
