package co.com.sofka.domain.funcion;

import co.com.sofka.domain.espectaculo.event.FuncionesAgregadas;
import co.com.sofka.domain.funcion.command.AsignarEspectadoresAFuncion;
import co.com.sofka.domain.funcion.event.*;
import co.com.sofka.domain.funcion.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Nombre;

import java.util.List;
import java.util.Objects;

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

    public void modificarNombre(FuncionID funcionID, Nombre nombre){
        Objects.requireNonNull(funcionID);
        Objects.requireNonNull(nombre);
        appendChange(new NombreFuncionModificado(funcionID,nombre));
    }

    public void asignarFechaInicio(FuncionID funcionID, FechaInicio fechaInicio){
        Objects.requireNonNull(funcionID);
        Objects.requireNonNull(fechaInicio);
        appendChange(new FechaInicioAsignada(funcionID,fechaInicio));
    }

    public void asignarHoraInicio(FuncionID funcionID, HoraInicio horaInicio){
        Objects.requireNonNull(funcionID);
        Objects.requireNonNull(horaInicio);
        appendChange(new HoraInicioAsignada(funcionID,horaInicio));
    }

    public void agregarEspectador(FuncionID funcionID, Espectador espectador){
        Objects.requireNonNull(funcionID);
        Objects.requireNonNull(espectador);
        appendChange(new EspectadoresAsignados(funcionID,espectador));
    }
}
