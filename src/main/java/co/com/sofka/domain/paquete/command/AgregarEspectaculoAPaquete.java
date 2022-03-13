package co.com.sofka.domain.paquete.command;

import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.paquete.value.PaqueteID;

import java.util.ArrayList;
import java.util.List;

public class AgregarEspectaculoAPaquete extends Command {
    private PaqueteID paqueteID;
    private List<Espectaculo> espectaculoList = new ArrayList();
    private Espectaculo espectaculo;

    public AgregarEspectaculoAPaquete(PaqueteID paqueteID, Espectaculo espectaculo) {
        this.paqueteID = paqueteID;
        this.espectaculoList.add(espectaculo);
        this.espectaculo = espectaculo;
    }

    public PaqueteID getPaqueteID() {
        return paqueteID;
    }

    public List<Espectaculo> getEspectaculoList() {
        return espectaculoList;
    }

    public Espectaculo getEspectaculo() {
        return espectaculo;
    }
}
