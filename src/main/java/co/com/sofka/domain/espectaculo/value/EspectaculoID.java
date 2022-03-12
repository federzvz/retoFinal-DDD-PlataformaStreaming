package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.paquete.value.PaqueteID;

public class EspectaculoID extends Identity {
    private EspectaculoID(Integer num){
        super(num.toString());
    }

    public static EspectaculoID of(Integer num){
        return new EspectaculoID(num);
    }
}
