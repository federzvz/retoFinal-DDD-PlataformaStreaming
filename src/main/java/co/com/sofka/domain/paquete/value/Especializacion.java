package co.com.sofka.domain.paquete.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especializacion implements ValueObject<String> {
    private final String especializacion;

    public Especializacion(){
        especializacion="";
    }

    public Especializacion(String especializacion) {
        this.especializacion = Objects.requireNonNull(especializacion);
        if (especializacion.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la especializacion no puede estar vacío.");
        }
    }

    public String Especializacion() {
        return especializacion;
    }


    @Override
    public String value() {
        return especializacion;
    }
}
