package co.com.sofka.domain.espectaculo.command;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.espectaculo.value.FechaRegistro;
import co.com.sofka.domain.generic.Command;

public class ModificarFechaRegistro extends Command {
    private EspectaculoID espectaculoID;
    private FechaRegistro fechaRegistro;

    public ModificarFechaRegistro(EspectaculoID espectaculoID, FechaRegistro fechaRegistro) {
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
