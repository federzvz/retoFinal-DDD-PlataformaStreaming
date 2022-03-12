package co.com.sofka.domain.paquete;

import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.event.BecaGenerada;
import co.com.sofka.domain.paquete.event.CastingEvaluado;
import co.com.sofka.domain.paquete.event.MentoriaGenerada;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.domain.paquete.value.*;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Duracion;
import co.com.sofka.generic.value.Nombre;

import java.util.List;
import java.util.Map;

public class Paquete extends AggregateEvent<PaqueteID> {
    protected Nombre nombre;
    protected List<Espectaculo> espectaculoList;
    protected Costo costo;
    protected BecaID becaID;
    protected List<Mentoria> mentoriaList;
    protected List<Casting> castingList;

    public Paquete(PaqueteID entityId, BecaID becaID, Nombre nombre, Costo costo) {
        super(entityId);
        appendChange(new PaqueteCreado(becaID,nombre,costo)).apply();
        subscribe(new PaqueteEventChange(this));
    }

    private Paquete(PaqueteID paqueteID){
        super(paqueteID);
        subscribe(new PaqueteEventChange(this));
    }

    //Para poder acceder a los eventos pasados
    public static Paquete from(PaqueteID paqueteID, List<DomainEvent> events){
        var paquete = new Paquete(paqueteID);
        events.forEach(paquete::applyEvent);
        return paquete;
    }

    public void generarBeca(Bono bono){
        appendChange(new BecaGenerada(bono)).apply();
    }

    public void generarMentoria(MentoriaID mentoriaID, PaqueteID paqueteID, Duracion duracion, Especializacion especializacion){
        appendChange(new MentoriaGenerada(mentoriaID, paqueteID, duracion, especializacion)).apply();
    }

    public void evaluarCasting(Evaluacion evaluacion){
        appendChange(new CastingEvaluado(evaluacion)).apply();
    }

    public List<Mentoria> MentoriaList() {
        return mentoriaList;
    }
}
