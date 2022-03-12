package co.com.sofka.generic.value;

import co.com.sofka.domain.generic.ValueObject;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Nacimiento implements ValueObject<SimpleDateFormat> {
    private final SimpleDateFormat value;

    public Nacimiento() {
        this.value= new SimpleDateFormat();
    }

    public Nacimiento(SimpleDateFormat value) {
        this.value = Objects.requireNonNull(value);
        //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
    }

    @Override
    public SimpleDateFormat value() {
        return value;
    }

}
