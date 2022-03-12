package co.com.sofka.domain.espectaculo.event;

import co.com.sofka.domain.espectaculo.value.OrganizadorID;
import co.com.sofka.domain.espectaculo.value.PlataformaID;
import co.com.sofka.domain.espectaculo.value.PremioID;
import co.com.sofka.domain.generic.DomainEvent;

public class EspectaculoCreado extends DomainEvent {
    private final OrganizadorID organizadorID;
    private final PremioID premioID;
    private final PlataformaID plataformaID;

    public EspectaculoCreado(OrganizadorID organizadorID, PremioID premioID, PlataformaID plataformaID) {
        super("espectaculo.espectaculocreado");
        this.organizadorID = organizadorID;
        this.premioID = premioID;
        this.plataformaID = plataformaID;
    }

    public OrganizadorID getOrganizadorID() {
        return organizadorID;
    }

    public PremioID getPremioID() {
        return premioID;
    }

    public PlataformaID getPlataformaID() {
        return plataformaID;
    }
}
