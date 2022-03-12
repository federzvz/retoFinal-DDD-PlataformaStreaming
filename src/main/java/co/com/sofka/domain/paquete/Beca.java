package co.com.sofka.domain.paquete;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.Bono;

public class Beca extends Entity<BecaID> {
    private Bono bono;

    public Beca(BecaID entityId, Bono bono) {
        super(entityId);
        this.bono = bono;
    }

    public Bono Bono() {
        return bono;
    }
}
