package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CapacidadMaxima implements ValueObject<Integer> {
    private final Integer capacidad;

    public CapacidadMaxima(){
        capacidad=10;
    }

    public CapacidadMaxima(Integer capacidad) {
        this.capacidad = Objects.requireNonNull(capacidad);
        if (capacidad<0) {
            throw new IllegalArgumentException("La capacidad máxima no puede ser un valor negativo.");
        }
        if (capacidad==0) {
            throw new IllegalArgumentException("La capacidad máxima no puede ser cero.");
        }
        if(capacidad<10){
            throw new IllegalArgumentException("La capacidad máxima no puede ser menor a 10.");
        }
        if (capacidad>1000000) {
            throw new IllegalArgumentException("La capacidad máxima no puede superar el millón.");
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
