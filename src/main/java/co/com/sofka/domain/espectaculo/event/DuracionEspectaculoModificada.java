package co.com.sofka.domain.espectaculo.event;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Duracion;

public class DuracionEspectaculoModificada extends DomainEvent {
    private EspectaculoID espectaculoID;
    private Duracion duracion;

    public DuracionEspectaculoModificada(EspectaculoID espectaculoID, Duracion duracion) {
        super("espectaculo.duracionmodificada");
        this.espectaculoID = espectaculoID;
        this.duracion = duracion;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
