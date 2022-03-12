package co.com.sofka.generic.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Integer> {
    private final Integer horas;

    public Duracion(){
        horas=0;
    }

    public Duracion(Integer horas) {
        this.horas = Objects.requireNonNull(horas);
        if (horas<1) {
            throw new IllegalArgumentException("La duracion en horas no puede ser menor que 1.");
        }
    }

    public Integer Duracion() {
        return horas;
    }


    @Override
    public Integer value() {
        return horas;
    }
}
