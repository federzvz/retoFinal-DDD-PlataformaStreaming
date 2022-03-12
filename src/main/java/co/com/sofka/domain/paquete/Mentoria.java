package co.com.sofka.domain.paquete;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.paquete.value.Especializacion;
import co.com.sofka.domain.paquete.value.MentoriaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Duracion;

public class Mentoria extends Entity<MentoriaID> {
    private PaqueteID paqueteID;
    private Duracion duracion;
    private Especializacion especializacion;

    public Mentoria(MentoriaID entityId, PaqueteID paqueteID, Duracion duracion, Especializacion especializacion){
        super(entityId);
        this.paqueteID=paqueteID;
        this.duracion = duracion;
        this.especializacion=especializacion;
    }

    public Duracion Duracion() {
        return duracion;
    }

    public Especializacion Especializacion() {
        return especializacion;
    }
}
