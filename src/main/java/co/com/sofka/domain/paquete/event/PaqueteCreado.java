package co.com.sofka.domain.paquete.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Nombre;

public class PaqueteCreado extends DomainEvent {
    private final BecaID becaID;
    private final Nombre nombre;
    private final Costo costo;

    public PaqueteCreado(BecaID becaID, Nombre nombre, Costo costo) {
        super("paquete.paquetecreado");
        this.nombre=nombre;
        this.costo=costo;
        this.becaID = becaID;
    }

    public BecaID getBecaID() {
        return becaID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Costo getCosto() {
        return costo;
    }
}
