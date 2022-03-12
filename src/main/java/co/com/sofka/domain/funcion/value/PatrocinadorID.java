package co.com.sofka.domain.funcion.value;

import co.com.sofka.domain.generic.Identity;

public class PatrocinadorID extends Identity {
    public PatrocinadorID(Integer num){
        super(num.toString());
    }

    public static PatrocinadorID of(Integer num){
        return new PatrocinadorID(num);
    }
}
