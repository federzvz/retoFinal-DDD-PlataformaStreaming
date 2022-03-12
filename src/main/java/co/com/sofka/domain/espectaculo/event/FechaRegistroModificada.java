package co.com.sofka.domain.espectaculo.event;

import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.espectaculo.value.FechaRegistro;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaRegistroModificada extends DomainEvent {
    private EspectaculoID espectaculoID;
    private FechaRegistro fechaRegistro;

    public FechaRegistroModificada(EspectaculoID espectaculoID, FechaRegistro fechaRegistro) {
        super("espectaculo.fecharegistromodificada");
        this.espectaculoID = espectaculoID;
        this.fechaRegistro = fechaRegistro;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public FechaRegistro getFechaRegistro() {
        return fechaRegistro;
    }
}
