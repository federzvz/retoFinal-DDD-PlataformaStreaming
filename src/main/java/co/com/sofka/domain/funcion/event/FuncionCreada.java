package co.com.sofka.domain.funcion.event;

import co.com.sofka.domain.funcion.value.ArtistaID;
import co.com.sofka.domain.funcion.value.PatrocinadorID;
import co.com.sofka.domain.generic.DomainEvent;

public class FuncionCreada extends DomainEvent {
    private final ArtistaID artistaID;
    private final PatrocinadorID patrocinadorID;

    public FuncionCreada(ArtistaID artistaID, PatrocinadorID patrocinadorID) {
        super("funcion.funcioncreada");
        this.artistaID = artistaID;
        this.patrocinadorID = patrocinadorID;
    }

    public ArtistaID getArtistaID() {
        return artistaID;
    }

    public PatrocinadorID getPatrocinadorID() {
        return patrocinadorID;
    }
}
