package co.com.sofka.domain.espectaculo.event;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class FuncionesAgregadas extends DomainEvent {
    private EspectaculoID espectaculoID;
    private List<Funcion> funcionList = new ArrayList<>();

    public FuncionesAgregadas(EspectaculoID espectaculoID, Funcion funcion) {
        super("espectaculo.funcionesagregadas");
        this.espectaculoID = espectaculoID;
        this.funcionList.add(funcion);
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public List<Funcion> getFuncionList() {
        return funcionList;
    }
}
