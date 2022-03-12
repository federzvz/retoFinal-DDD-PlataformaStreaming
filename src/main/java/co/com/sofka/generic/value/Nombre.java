package co.com.sofka.generic.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String value;

    public Nombre(){
        this.value="";
    }

    public Nombre(String nombre) {
        this.value = Objects.requireNonNull(nombre);
        if (nombre.length()<5) {
            throw new IllegalArgumentException("El nombre no puede tener menos de 5 carácteres.");
        }
        if(nombre.contains("-") ||
            nombre.contains("+") ||
            nombre.contains("^") ||
            nombre.contains(".") ||
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
            throw new IllegalArgumentException("Un nombre no puede contener los carácteres: -+^.:,$#%&/=");
        }
        if(nombre.length()>50){
            throw new IllegalArgumentException("Un nombre no puede tener mas de 50 carácteres.");
        }
    }

    public String Nombre() {
        return value;
    }


    @Override
    public String value() {
        return value;
    }
}
