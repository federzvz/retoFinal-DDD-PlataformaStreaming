package co.com.sofka.generic.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class URL implements ValueObject<String> {
    private final String value;

    public URL(){
        this.value="";
    }

    public URL(String value) {
        this.value = Objects.requireNonNull(value);
        if (!value.contains("https://") || !value.contains("https://") ) {
            throw new IllegalArgumentException("La URL no es válida.");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("La URL no puede estar vacía.");
        }
    }

    public String URL() {
        return value;
    }

    @Override
    public String value() {
        return value;
    }
}
