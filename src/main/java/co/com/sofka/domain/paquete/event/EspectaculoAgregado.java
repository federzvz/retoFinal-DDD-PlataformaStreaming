package co.com.sofka.domain.paquete.event;

import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.value.PaqueteID;

import java.util.ArrayList;
import java.util.List;

public class EspectaculoAgregado extends DomainEvent {
    private PaqueteID paqueteID;
    private List<Espectaculo> espectaculoList= new ArrayList();

    public EspectaculoAgregado(PaqueteID paqueteID, Espectaculo espectaculo) {
        super("paquete.espectaculoagregado");
        this.paqueteID = paqueteID;
        this.espectaculoList.add(espectaculo);
    }

    public PaqueteID getPaqueteID() {
        return paqueteID;
    }

    public List<Espectaculo> getEspectaculoList() {
        return espectaculoList;
    }
}
