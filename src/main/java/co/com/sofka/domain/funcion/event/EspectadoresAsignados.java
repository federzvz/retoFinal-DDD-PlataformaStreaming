package co.com.sofka.domain.funcion.event;

import co.com.sofka.domain.funcion.Espectador;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class EspectadoresAsignados extends DomainEvent {
    private FuncionID funcionID;
    private List<Espectador> espectadorList = new ArrayList<>();

    public EspectadoresAsignados(FuncionID funcionID, Espectador espectador) {
        super("funcion.espectadoresasignados");
        this.funcionID = funcionID;
        this.espectadorList.add(espectador);
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public List<Espectador> getEspectadorList() {
        return espectadorList;
    }
}
