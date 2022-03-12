package co.com.sofka.domain.espectaculo.event;

import co.com.sofka.domain.espectaculo.value.CapacidadMinima;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.generic.DomainEvent;

public class CapacidadMinimaModificada extends DomainEvent {
    protected EspectaculoID espectaculoID;
    protected CapacidadMinima capacidadMinima;

    public CapacidadMinimaModificada(EspectaculoID espectaculoID, CapacidadMinima capacidadMinima) {
        super("espectaculo.capacidadminimamodificada");
        this.espectaculoID = espectaculoID;
        this.capacidadMinima = capacidadMinima;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public CapacidadMinima getCapacidadMinima() {
        return capacidadMinima;
    }
}
