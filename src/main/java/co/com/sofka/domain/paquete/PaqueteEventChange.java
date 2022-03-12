package co.com.sofka.domain.paquete;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.paquete.event.BecaGenerada;
import co.com.sofka.domain.paquete.event.MentoriaGenerada;
import co.com.sofka.domain.paquete.event.PaqueteCreado;

import java.util.ArrayList;

public class PaqueteEventChange extends EventChange {
    public PaqueteEventChange(Paquete paquete) {

        apply((PaqueteCreado event) -> {
            paquete.becaID=event.getBecaID();
            paquete.castingList=new ArrayList<>();
            paquete.mentoriaList=new ArrayList<>();
            paquete.espectaculoList=new ArrayList<>();
        });

        apply((MentoriaGenerada event) -> {
            paquete.mentoriaList.add(new Mentoria(event.getMentoriaID(),event.getPaqueteID(), event.getDuracion(),event.getEspecializacion()));
        });
    }
}
