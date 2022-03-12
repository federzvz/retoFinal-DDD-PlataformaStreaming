package co.com.sofka.domain.paquete.value;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.paquete.Beca;

public class BecaID extends Identity {
    public BecaID(Integer num){
        super(num.toString());
    }


    public static BecaID of(Integer num){
        return new BecaID(num);
    }
}