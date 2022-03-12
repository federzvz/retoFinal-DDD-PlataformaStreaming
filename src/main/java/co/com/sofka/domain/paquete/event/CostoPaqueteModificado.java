package co.com.sofka.domain.paquete.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;

public class CostoPaqueteModificado extends DomainEvent {
    protected PaqueteID paqueteID;
    protected Costo costo;

    public CostoPaqueteModificado(PaqueteID paqueteID, Costo costo) {
        super("paquete.costomodificado");
        this.paqueteID = paqueteID;
        this.costo = costo;
    }

    public PaqueteID getPaqueteID() {
        return paqueteID;
    }

    public Costo getCosto() {
        return costo;
    }
}
