package co.com.sofka.domain.funcion.command;

import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.value.Nombre;

public class ModificarNombreFuncion extends Command {
    private FuncionID funcionID;
    private Nombre nombre;

    public ModificarNombreFuncion(FuncionID funcionID, Nombre nombre) {
        this.funcionID = funcionID;
        this.nombre = nombre;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
