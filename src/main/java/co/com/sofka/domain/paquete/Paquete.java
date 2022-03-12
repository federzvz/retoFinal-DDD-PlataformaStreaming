package co.com.sofka.domain.paquete;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Nombre;

import java.util.List;

public class Paquete extends AggregateEvent<PaqueteID> {
    protected Nombre nombre;
    //protected Map<EspectaculoID, Espectaculo> espectaculos;
    protected Costo costo;
    protected BecaID becaID;
    protected List<Mentoria> mentoriaList;
    protected List<Casting> castingList;

    public Paquete(PaqueteID entityId, BecaID becaID) {
        super(entityId);
        appendChange(new PaqueteCreado(becaID)).apply();
        subscribe(new PaqueteEventChange(this));
    }

    private Paquete(PaqueteID paqueteID){
        super(paqueteID);
        subscribe(new PaqueteEventChange(this));
    }

    //Para poder acceder a los eventos pasados
    public static Paquete from(PaqueteID paqueteID, List<DomainEvent> events){
        var paquete = new Paquete(paqueteID);
        events.forEach(paquete::applyEvent);
        return paquete;
    }

}
