package co.com.sofka.domain.espectaculo.event;

import co.com.sofka.domain.espectaculo.value.CapacidadMaxima;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.generic.DomainEvent;

public class CapacidadMaximaModificada extends DomainEvent {
    protected EspectaculoID espectaculoID;
    protected CapacidadMaxima capacidadMaxima;

    public CapacidadMaximaModificada(EspectaculoID espectaculoID, CapacidadMaxima capacidadMaxima) {
        super("espectaculo.capacidadmaximamodificada");
        this.espectaculoID = espectaculoID;
        this.capacidadMaxima = capacidadMaxima;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public CapacidadMaxima getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
