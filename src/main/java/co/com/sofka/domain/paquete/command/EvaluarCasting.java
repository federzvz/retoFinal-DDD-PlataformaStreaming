package co.com.sofka.domain.paquete.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.paquete.value.CastingID;
import co.com.sofka.domain.paquete.value.Evaluacion;
import co.com.sofka.domain.paquete.value.PaqueteID;

public class EvaluarCasting extends Command {
    private final CastingID castingID;
    private final Evaluacion evaluacion;

    public EvaluarCasting(CastingID castingID, Evaluacion evaluacion) {
        this.castingID = castingID;
        this.evaluacion = evaluacion;
    }

    public CastingID getCastingID() {
        return castingID;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }
}
