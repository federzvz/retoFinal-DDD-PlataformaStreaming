package co.com.sofka.generic.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nickname implements ValueObject<String> {
    private final String value;

    public Nickname(){
        this.value="";
    }

    public Nickname(String nombre) {
        this.value = Objects.requireNonNull(nombre);
        if (nombre.length()<7) {
            throw new IllegalArgumentException("El nickname no puede tener menos de 7 carácteres.");
        }
        if(
            nombre.contains("+") ||
            nombre.contains("^") ||
            nombre.contains(":") ||
            nombre.contains(",") ||
            nombre.contains("!") ||
            nombre.contains("#") ||
            nombre.contains("%") ||
            nombre.contains("&") ||
            nombre.contains("/") ||
            nombre.contains("=") ||
            nombre.contains("$")
        ){
            throw new IllegalArgumentException("Un nickname no puede contener los carácteres: +^:,$#%&/=");
        }
        if(nombre.length()>25){
            throw new IllegalArgumentException("Un nickname no puede tener mas de 25 carácteres.");
        }
    }

    public String Nickname() {
        return value;
    }


    @Override
    public String value() {
        return value;
    }
}
