package co.com.sofka.domain.funcion.event;

import co.com.sofka.domain.funcion.value.FechaInicio;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaInicioAsignada extends DomainEvent {
    private FuncionID funcionID;
    private FechaInicio fechaInicio;

    public FechaInicioAsignada(FuncionID funcionID, FechaInicio fechaInicio) {
        super("funcion.fechainicioasignada");
        this.funcionID = funcionID;
        this.fechaInicio = fechaInicio;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public FechaInicio getFechaInicio() {
        return fechaInicio;
    }
}
