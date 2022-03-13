package co.com.sofka.domain.funcion.value;

import co.com.sofka.domain.generic.Identity;

public class EspectadorID extends Identity {
    public EspectadorID(Integer num){
        super(num.toString());
    }

    public static EspectadorID of(Integer num){
        return new EspectadorID(num);
    }
}
