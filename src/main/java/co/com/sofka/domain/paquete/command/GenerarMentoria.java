package co.com.sofka.domain.paquete.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.paquete.value.Especializacion;
import co.com.sofka.domain.paquete.value.MentoriaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Duracion;

public class GenerarMentoria extends Command {
    private final MentoriaID mentoriaID;
    private final PaqueteID paqueteID;
    private final Duracion duracion;
    private final Especializacion especializacion;

    public GenerarMentoria(MentoriaID mentoriaID, PaqueteID paqueteID, Duracion duracion, Especializacion especializacion) {
        this.mentoriaID=mentoriaID;
        this.paqueteID=paqueteID;
        this.duracion = duracion;
        this.especializacion = especializacion;
    }

    public MentoriaID getMentoriaID() {
        return mentoriaID;
    }

    public PaqueteID getPaqueteID() {
        return paqueteID;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }
}
