package co.com.sofka.domain.funcion.event;

import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Nombre;

public class NombreFuncionModificado extends DomainEvent {
    private FuncionID funcionID;
    private Nombre nombre;

    public NombreFuncionModificado(FuncionID funcionID, Nombre nombre) {
        super("funcion.nombrefuncionmodificado");
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
