package co.com.sofka.domain.funcion.command;

import co.com.sofka.domain.funcion.value.FechaInicio;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.generic.Command;

public class AsignarFechaInicio extends Command {
    private FuncionID funcionID;
    private FechaInicio fechaInicio;

    public AsignarFechaInicio(FuncionID funcionID, FechaInicio fechaInicio) {
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
