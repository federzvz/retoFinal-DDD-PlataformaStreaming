package co.com.sofka.generic.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {
    private final String value;

    public Email(){
        value="";
    }

    public Email(String value) {
        this.value = Objects.requireNonNull(value);

        if (!value.contains("@")) {
            throw new IllegalArgumentException("El Email ingresado no es válido.");
        }
    }

    public String Email() {
        return value;
    }

    @Override
    public String value() {
        return value;
    }
}
