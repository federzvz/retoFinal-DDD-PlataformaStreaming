package co.com.sofka.domain.espectaculo.command;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.espectaculo.value.OrganizadorID;
import co.com.sofka.domain.espectaculo.value.PlataformaID;
import co.com.sofka.domain.espectaculo.value.PremioID;
import co.com.sofka.domain.generic.Command;

public class CrearEspectaculo extends Command {
    private final EspectaculoID espectaculoID;
    private final OrganizadorID organizadorID;
    private final PremioID premioID;
    private final PlataformaID plataformaID;

    public CrearEspectaculo(EspectaculoID espectaculoID, OrganizadorID organizadorID, PremioID premioID, PlataformaID plataformaID) {
        this.espectaculoID= espectaculoID;
        this.organizadorID = organizadorID;
        this.premioID = premioID;
        this.plataformaID = plataformaID;
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
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