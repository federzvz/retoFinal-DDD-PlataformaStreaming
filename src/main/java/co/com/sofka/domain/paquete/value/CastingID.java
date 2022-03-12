package co.com.sofka.domain.paquete.value;

import co.com.sofka.domain.generic.Identity;

public class CastingID extends Identity {
    private CastingID(Integer num){
        super(num.toString());
    }

    public static CastingID of(Integer num){
        return new CastingID(num);
    }
}
