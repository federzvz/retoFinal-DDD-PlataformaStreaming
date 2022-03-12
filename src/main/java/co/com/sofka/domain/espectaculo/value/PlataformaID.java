package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.Identity;

public class PlataformaID extends Identity {
    private PlataformaID(Integer num){
        super(num.toString());
    }

    public static PlataformaID of(Integer num){
        return new PlataformaID(num);
    }
}
