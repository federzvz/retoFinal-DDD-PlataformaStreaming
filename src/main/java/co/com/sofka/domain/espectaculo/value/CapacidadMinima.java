package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CapacidadMinima implements ValueObject<Integer> {
    private final Integer capacidad;

    public CapacidadMinima(){
        capacidad=1;
    }

    public CapacidadMinima(Integer capacidad) {
        this.capacidad = Objects.requireNonNull(capacidad);
        if(capacidad<0){
            throw new IllegalArgumentException("La capacidad minima no puede ser un valor negativo.");
        }
        if (capacidad==0) {
            throw new IllegalArgumentException("La capacidad minima no puede ser cero.");
        }
        if (capacidad>=1000000) {
            throw new IllegalArgumentException("La capacidad minima no puede ser igual o mayor a la capacidad máxima permitida.");
        }
    }

    public Integer Capacidad() {
        return capacidad;
    }


    @Override
    public Integer value() {
        return capacidad;
    }
}
