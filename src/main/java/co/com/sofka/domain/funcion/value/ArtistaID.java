package co.com.sofka.domain.funcion.value;

import co.com.sofka.domain.generic.Identity;

public class ArtistaID extends Identity {
    private ArtistaID(Integer num){
        super(num.toString());
    }

    public static ArtistaID of(Integer num){
        return new ArtistaID(num);
    }
}
