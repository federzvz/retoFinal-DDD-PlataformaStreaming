package co.com.sofka.domain.paquete.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;

public class CambiarCostoPaquete extends Command {
    protected PaqueteID paqueteID;
    protected Costo costo;

    public CambiarCostoPaquete(PaqueteID paqueteID, Costo costo) {
        this.paqueteID = paqueteID;
        this.costo = costo;
    }

    public PaqueteID getPaqueteID() {
        return paqueteID;
    }

    public Costo getCosto() {
        return costo;
    }
}
