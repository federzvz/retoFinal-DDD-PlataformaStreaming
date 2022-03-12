package co.com.sofka.domain.paquete;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.paquete.value.CastingID;
import co.com.sofka.domain.paquete.value.Evaluacion;

public class Casting extends Entity<CastingID> {
    private Evaluacion evaluacion;

    public Casting(CastingID entityId, Evaluacion evaluacion) {
        super(entityId);
        this.evaluacion = evaluacion;
    }

    public Evaluacion Evaluacion() {
        return evaluacion;
    }
}
