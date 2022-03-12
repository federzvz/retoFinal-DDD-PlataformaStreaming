package co.com.sofka.domain.funcion;

import co.com.sofka.domain.funcion.value.PatrocinadorID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.value.Nombre;
import co.com.sofka.generic.value.URL;

public class Patrocinador extends Entity<PatrocinadorID> {
    private Nombre nombre;
    private URL url;

    public Patrocinador(PatrocinadorID entityId, Nombre nombre, URL url) {
        super(entityId);
        this.nombre = nombre;
        this.url = url;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public URL URL() {
        return url;
    }
}
