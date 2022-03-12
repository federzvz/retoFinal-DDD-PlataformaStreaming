package co.com.sofka.domain.espectaculo.command;

import co.com.sofka.domain.espectaculo.value.CapacidadMinima;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.generic.Command;

public class ModificarCapacidadMinima extends Command {
    protected EspectaculoID espectaculoID;
    protected CapacidadMinima capacidadMinima;

    public ModificarCapacidadMinima(EspectaculoID espectaculoID, CapacidadMinima capacidadMinima) {
        this.espectaculoID = espectaculoID;
        this.capacidadMinima = capacidadMinima;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public CapacidadMinima getCapacidadMinima() {
        return capacidadMinima;
    }
}
