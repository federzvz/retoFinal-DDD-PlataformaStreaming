package co.com.sofka.domain.espectaculo.event;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Costo;

public class CostoEspectaculoModificado extends DomainEvent {
    private final EspectaculoID espectaculoID;
    private final Costo costo;

    public CostoEspectaculoModificado(EspectaculoID espectaculoID, Costo costo) {
        super("espectaculo.costomodificado");
        this.espectaculoID = espectaculoID;
        this.costo = costo;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public Costo getCosto() {
        return costo;
    }
}
