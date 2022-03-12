package co.com.sofka.domain.funcion;

import co.com.sofka.domain.funcion.value.EspectadorID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.value.Email;
import co.com.sofka.generic.value.Nacimiento;
import co.com.sofka.generic.value.Nickname;
import co.com.sofka.generic.value.Nombre;

public class Espectador extends Entity<EspectadorID> {
    private Nickname nickname;
    private Nombre nombre;
    private Email email;
    private Nacimiento nacimiento;

    public Espectador(EspectadorID entityId, Nickname nickname, Nombre nombre, Email email, Nacimiento nacimiento) {
        super(entityId);
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
        this.nacimiento = nacimiento;
    }

    public Nickname Nickname() {
        return nickname;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Email Email() {
        return email;
    }

    public Nacimiento Nacimiento() {
        return nacimiento;
    }
}
