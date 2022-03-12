package co.com.sofka.domain.espectaculo;

import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class EspectaculoEventChange extends EventChange {
    public EspectaculoEventChange(Espectaculo espectaculo){
        apply((EspectaculoCreado event) -> {
            espectaculo.organizadorID=event.getOrganizadorID();
            espectaculo.premioID=event.getPremioID();
            espectaculo.plataformaID=event.getPlataformaID();
            espectaculo.funcionList=new ArrayList<>();
        });
    }
}