package co.com.sofka.domain.espectaculo;

import co.com.sofka.domain.espectaculo.event.*;
import co.com.sofka.domain.espectaculo.value.*;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Duracion;
import co.com.sofka.generic.value.Nombre;

import java.util.List;
import java.util.Objects;

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
    protected List<Funcion> funcionList;

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

    public void modificarCapacidadMaxima(EspectaculoID espectaculoID, CapacidadMaxima capacidadMaxima){
        Objects.requireNonNull(espectaculoID);
        Objects.requireNonNull(capacidadMaxima);
        appendChange(new CapacidadMaximaModificada(espectaculoID,capacidadMaxima)).apply();
    }

    public void modificarCapacidadMinima(EspectaculoID espectaculoID, CapacidadMinima capacidadMinima){
        Objects.requireNonNull(espectaculoID);
        Objects.requireNonNull(capacidadMinima);
        appendChange(new CapacidadMinimaModificada(espectaculoID,capacidadMinima)).apply();
    }

    public void modificarCosto(EspectaculoID espectaculoID, Costo costo){
        Objects.requireNonNull(espectaculoID);
        Objects.requireNonNull(costo);
        appendChange(new CostoEspectaculoModificado(espectaculoID,costo)).apply();
    }

    public void modificarDuracion(EspectaculoID espectaculoID, Duracion duracion){
        Objects.requireNonNull(espectaculoID);
        Objects.requireNonNull(duracion);
        appendChange(new DuracionEspectaculoModificada(espectaculoID,duracion)).apply();
    }

    public void modificarFechaRegistro(EspectaculoID espectaculoID, FechaRegistro fechaRegistro){
        Objects.requireNonNull(espectaculoID);
        Objects.requireNonNull(fechaRegistro);
        appendChange(new FechaRegistroModificada(espectaculoID,fechaRegistro));
    }

    public void agregarFunciones(EspectaculoID espectaculoID, Funcion funcion){
        Objects.requireNonNull(espectaculoID);
        Objects.requireNonNull(funcion);
        appendChange(new FuncionesAgregadas(espectaculoID,funcion));
    }
}
