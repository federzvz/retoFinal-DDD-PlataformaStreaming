package co.com.sofka.domain.funcion.event;

import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.funcion.value.HoraInicio;
import co.com.sofka.domain.generic.DomainEvent;

public class HoraInicioAsignada extends DomainEvent {
    private FuncionID funcionID;
    private HoraInicio horaInicio;

    public HoraInicioAsignada(FuncionID funcionID, HoraInicio horaInicio) {
        super("funcion.horainicioasignada");
        this.funcionID = funcionID;
        this.horaInicio = horaInicio;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public HoraInicio getHoraInicio() {
        return horaInicio;
    }
}
