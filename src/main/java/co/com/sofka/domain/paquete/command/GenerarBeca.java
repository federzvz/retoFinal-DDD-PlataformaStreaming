package co.com.sofka.domain.paquete.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.paquete.value.Bono;
import co.com.sofka.domain.paquete.value.PaqueteID;

public class GenerarBeca extends Command {
    private final PaqueteID paqueteID;
    private final Bono bono;

    public GenerarBeca(PaqueteID paqueteID, Bono bono) {
        this.paqueteID = paqueteID;
        this.bono = bono;
    }

    public PaqueteID getPaqueteID() {
        return paqueteID;
    }

    public Bono getBono() {
        return bono;
    }
}
