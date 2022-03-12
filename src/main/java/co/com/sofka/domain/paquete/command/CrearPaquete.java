package co.com.sofka.domain.paquete.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.PaqueteID;

public class CrearPaquete extends Command {
    private final PaqueteID paqueteID;
    private final BecaID becaID;

    public CrearPaquete(PaqueteID paqueteID, BecaID becaID) {
        this.paqueteID = paqueteID;
        this.becaID = becaID;
    }

    public PaqueteID getPaqueteID() {
        return paqueteID;
    }

    public BecaID getBecaID() {
        return becaID;
    }
}
