package co.com.sofka.domain.funcion.command;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.funcion.Espectador;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.generic.Command;

import java.util.ArrayList;
import java.util.List;

public class AsignarEspectadoresAFuncion extends Command {
    private FuncionID funcionID;
    private List<Espectador> espectadorList = new ArrayList<>();
    private Espectador espectador;

    public AsignarEspectadoresAFuncion(FuncionID funcionID, Espectador espectador) {
        this.funcionID = funcionID;
        this.espectadorList.add(espectador);
        this.espectador=espectador;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public List<Espectador> getEspectadorList() {
        return espectadorList;
    }

    public Espectador getEspectador() {
        return espectador;
    }
}
