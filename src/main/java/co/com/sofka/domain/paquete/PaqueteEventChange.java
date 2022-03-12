package co.com.sofka.domain.paquete;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.generic.value.Costo;

import java.util.ArrayList;

public class PaqueteEventChange extends EventChange {
    public PaqueteEventChange(Paquete paquete) {

        apply((PaqueteCreado event) -> {
            paquete.becaID=event.getBecaID();
            paquete.castingList=new ArrayList<>();
            paquete.mentoriaList=new ArrayList<>();
        });






    }
}
