package co.com.sofka.domain.espectaculo.command;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.value.Costo;

public class ModificarCostoEspectaculo extends Command {
    private final EspectaculoID espectaculoID;
    private final Costo costo;

    public ModificarCostoEspectaculo(EspectaculoID espectaculoID, Costo costo) {
        this.espectaculoID = espectaculoID;
        this.costo = costo;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public Costo getCosto() {
        return costo;
    }
}
