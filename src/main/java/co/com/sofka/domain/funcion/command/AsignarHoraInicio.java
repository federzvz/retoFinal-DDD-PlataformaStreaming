package co.com.sofka.domain.funcion.command;

import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.funcion.value.HoraInicio;
import co.com.sofka.domain.generic.Command;

public class AsignarHoraInicio extends Command {
    private FuncionID funcionID;
    private HoraInicio horaInicio;

    public AsignarHoraInicio(FuncionID funcionID, HoraInicio horaInicio) {
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
