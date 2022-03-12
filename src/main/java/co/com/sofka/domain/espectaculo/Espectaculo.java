package co.com.sofka.domain.espectaculo;

import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.espectaculo.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.PaqueteEventChange;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Duracion;
import co.com.sofka.generic.value.Nombre;

import java.util.List;

public class Espectaculo extends AggregateEvent<EspectaculoID> {
    protected Nombre nombre;
    protected CapacidadMaxima capacidadMaxima;
    protected CapacidadMinima capacidadMinima;
    protected Costo costo;
    protected Duracion duracion;
    protected FechaRegistro fechaRegistro;
    protected OrganizadorID organizadorID;
    protected PremioID premioID;
    protected PlataformaID plataformaID;
    //protected FuncionID funcionID;

    public Espectaculo(EspectaculoID entityId, OrganizadorID organizadorID, PremioID premioID, PlataformaID plataformaID) {
        super(entityId);
        appendChange(new EspectaculoCreado(organizadorID, premioID, plataformaID)).apply();
        subscribe(new EspectaculoEventChange(this));
    }

    private Espectaculo(EspectaculoID espectaculoID){
        super(espectaculoID);
        subscribe(new EspectaculoEventChange(this));
    }

    //Para poder acceder a los eventos pasados
    public static Espectaculo from(EspectaculoID espectaculoID, List<DomainEvent> events){
        var espectaculo = new Espectaculo(espectaculoID);
        events.forEach(espectaculo::applyEvent);
        return espectaculo;
    }
}
