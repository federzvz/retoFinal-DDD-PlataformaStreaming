package co.com.sofka.domain.funcion;

import co.com.sofka.domain.funcion.event.FuncionCreada;
import co.com.sofka.domain.funcion.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Nombre;

import java.util.List;

public class Funcion extends AggregateEvent<FuncionID> {
    protected Nombre nombre;
    protected FechaInicio fechaInicio;
    protected HoraInicio horaInicio;
    protected List<Espectador> espectadorList;
    protected ArtistaID artistaID;
    protected PatrocinadorID patrocinadorID;

    public Funcion(FuncionID entityId, ArtistaID artistaID, PatrocinadorID patrocinadorID) {
        super(entityId);
        appendChange(new FuncionCreada(artistaID, patrocinadorID)).apply();
        subscribe(new FuncionEventChange(this));
    }

    private Funcion(FuncionID funcionID){
        super(funcionID);
        subscribe(new FuncionEventChange(this));
    }

    public static Funcion from(FuncionID funcionID, List<DomainEvent> events){
        var funcion = new Funcion(funcionID);
        events.forEach(funcion::applyEvent);
        return funcion;
    }
}
