package co.com.sofka.domain.espectaculo;

import co.com.sofka.domain.espectaculo.value.Descripcion;
import co.com.sofka.domain.espectaculo.value.PlataformaID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.value.Nombre;
import co.com.sofka.generic.value.URL;

public class Plataforma extends Entity<PlataformaID> {
    private Nombre nombre;
    private Descripcion descripcion;
    private URL url;

    public Plataforma(PlataformaID entityId, Nombre nombre, Descripcion descripcion, URL url) {
        super(entityId);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Descripcion Descripcion() {
        return descripcion;
    }

    public URL Url() {
        return url;
    }
}
