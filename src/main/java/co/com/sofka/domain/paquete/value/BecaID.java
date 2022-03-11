package co.com.sofka.domain.paquete.value;

import co.com.sofka.domain.generic.Identity;

public class BecaID extends Identity {
    private BecaID(Integer num){
        super(num.toString());
    }

    public static BecaID of(Integer num){
        return new BecaID(num);
    }
}