package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(){
        value="";
    }

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacío.");
        }
        if (value.length()>255) {
            throw new IllegalArgumentException("La longitud de la descripcion no puede superar los 255 carácteres.");
        }
    }

    public String Descripcion() {
        return value;
    }


    @Override
    public String value() {
        return value;
    }
}
