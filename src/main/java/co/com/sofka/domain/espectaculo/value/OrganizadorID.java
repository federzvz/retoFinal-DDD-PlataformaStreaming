package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.Identity;

public class OrganizadorID extends Identity {
    private OrganizadorID(Integer num){
        super(num.toString());
    }

    public static OrganizadorID of(Integer num){
        return new OrganizadorID(num);
    }
}
