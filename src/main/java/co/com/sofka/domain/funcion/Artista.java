package co.com.sofka.domain.funcion;

import co.com.sofka.domain.funcion.value.ArtistaID;
import co.com.sofka.domain.funcion.value.Biografia;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.value.Email;
import co.com.sofka.generic.value.Nacimiento;
import co.com.sofka.generic.value.Nickname;
import co.com.sofka.generic.value.Nombre;

public class Artista extends Entity<ArtistaID> {
    private Nickname nickname;
    private Nombre nombre;
    private Email email;
    private Nacimiento nacimiento;
    private Biografia biografia;

    public Artista(ArtistaID entityId, Nickname nickname, Nombre nombre, Email email, Nacimiento nacimiento, Biografia biografia) {
        super(entityId);
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
        this.nacimiento = nacimiento;
        this.biografia = biografia;
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

    public Biografia Biografia() {
        return biografia;
    }
}
