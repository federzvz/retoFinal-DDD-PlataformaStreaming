package co.com.sofka.domain.funcion.value;

import co.com.sofka.domain.generic.Identity;

public class FuncionID extends Identity {
    public FuncionID(Integer num){
        super(num.toString());
    }

    public static FuncionID of(Integer num){
        return new FuncionID(num);
    }
}
