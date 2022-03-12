package co.com.sofka.domain.paquete;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.paquete.value.Especializacion;
import co.com.sofka.domain.paquete.value.MentoriaID;
import co.com.sofka.generic.value.Duracion;

public class Mentoria extends Entity<MentoriaID> {
    private final Duracion duracion;
    private final Especializacion especializacion;

    public Mentoria(MentoriaID entityId, Duracion duracion, Especializacion especializacion){
        super(entityId);
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
