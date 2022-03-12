package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.Identity;

public class PremioID extends Identity {
    public PremioID(Integer num){
        super(num.toString());
    }

    public static PremioID of(Integer num){
        return new PremioID(num);
    }
}

