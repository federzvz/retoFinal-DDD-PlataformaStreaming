package co.com.sofka.domain.espectaculo.command;

import co.com.sofka.domain.espectaculo.value.CapacidadMaxima;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.generic.Command;

public class ModificarCapacidadMaxima extends Command {
    protected EspectaculoID espectaculoID;
    protected CapacidadMaxima capacidadMaxima;

    public ModificarCapacidadMaxima(EspectaculoID espectaculoID, CapacidadMaxima capacidadMaxima) {
        this.espectaculoID = espectaculoID;
        this.capacidadMaxima = capacidadMaxima;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public CapacidadMaxima getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
