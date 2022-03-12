package co.com.sofka.domain.paquete.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.value.Evaluacion;

public class CastingEvaluado extends DomainEvent {
    private final Evaluacion evaluacion;

    public CastingEvaluado(Evaluacion evaluacion) {
        super("paquete.castingevaluado");
        this.evaluacion = evaluacion;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }
}
