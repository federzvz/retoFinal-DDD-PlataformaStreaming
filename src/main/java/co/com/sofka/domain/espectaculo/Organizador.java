package co.com.sofka.domain.espectaculo;

import co.com.sofka.domain.espectaculo.value.OrganizadorID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.Bono;
import co.com.sofka.generic.value.Email;
import co.com.sofka.generic.value.Nombre;

public class Organizador extends Entity<OrganizadorID> {
    private Nombre nombre;
    private Email email;

    public Organizador(OrganizadorID entityId, Nombre nombre, Email email) {
        super(entityId);
        this.nombre = nombre;
        this.email = email;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Email Email() {
        return email;
    }
}
