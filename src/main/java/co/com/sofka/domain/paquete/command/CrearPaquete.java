package co.com.sofka.domain.paquete.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Nombre;

public class CrearPaquete extends Command {
    private final PaqueteID paqueteID;
    private final BecaID becaID;
    private final Nombre nombre;
    private final Costo costo;

    public CrearPaquete(PaqueteID paqueteID, BecaID becaID, Nombre nombre, Costo costo) {
        this.paqueteID = paqueteID;
        this.becaID = becaID;
        this.nombre=nombre;
        this.costo=costo;
    }

    public PaqueteID getPaqueteID() {
        return paqueteID;
    }

    public BecaID getBecaID() {
        return becaID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Costo getCosto() {
        return costo;
    }
}
