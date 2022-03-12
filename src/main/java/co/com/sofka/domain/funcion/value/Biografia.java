package co.com.sofka.domain.funcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Biografia implements ValueObject<String> {
    private final String value;

    public Biografia(){
        value="";
    }

    public Biografia(String value) {
        this.value = Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("La Biografia no puede estar vacío.");
        }
        if (value.length()>255) {
            throw new IllegalArgumentException("La longitud de la Biografia no puede superar los 255 carácteres.");
        }
    }

    public String Biografia() {
        return value;
    }


    @Override
    public String value() {
        return value;
    }
}
