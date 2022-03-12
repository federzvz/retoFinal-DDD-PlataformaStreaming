package co.com.sofka.domain.paquete.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.value.BecaID;

public class PaqueteCreado extends DomainEvent {
    private final BecaID becaID;

    public PaqueteCreado(BecaID becaID) {
        super("paquete.paquetecreado");
        this.becaID = becaID;
    }

    public BecaID getBecaID() {
        return becaID;
    }
}
