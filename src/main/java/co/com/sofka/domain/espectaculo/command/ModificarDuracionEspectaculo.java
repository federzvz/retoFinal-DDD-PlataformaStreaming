package co.com.sofka.domain.espectaculo.command;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.value.Duracion;

public class ModificarDuracionEspectaculo extends Command {
    private final EspectaculoID espectaculoID;
    private final Duracion duracion;

    public ModificarDuracionEspectaculo(EspectaculoID espectaculoID, Duracion duracion) {
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
