package co.com.sofka.domain.paquete.value;

import co.com.sofka.domain.generic.Identity;

public class PaqueteID extends Identity {
    private PaqueteID(Integer num){
        super(num.toString());
    }

    public static PaqueteID of(Integer num){
        return new PaqueteID(num);
    }
}
