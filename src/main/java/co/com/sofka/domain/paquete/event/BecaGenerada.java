package co.com.sofka.domain.paquete.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.Bono;

public class BecaGenerada extends DomainEvent {
    private final Bono bono;

    public BecaGenerada(Bono bono) {
        super("paquete.becagenerada");
        this.bono = bono;
    }

    public Bono getBono() {
        return bono;
    }
}
