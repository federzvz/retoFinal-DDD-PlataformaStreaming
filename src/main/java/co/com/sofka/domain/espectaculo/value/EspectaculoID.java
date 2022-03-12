package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.Identity;

public class EspectaculoID extends Identity {
    private EspectaculoID(Integer num){
        super(num.toString());
    }

    public static EspectaculoID of(Integer num){
        return new EspectaculoID(num);
    }
}
