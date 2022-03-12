package co.com.sofka.domain.espectaculo;

import co.com.sofka.domain.espectaculo.value.Articulo;
import co.com.sofka.domain.espectaculo.value.PremioID;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.value.Nombre;

import java.util.List;

public class Premio extends Entity<PremioID> {
    private final Nombre nombre;
    private final List<Articulo> articuloList;

    public Premio(PremioID entityId, Nombre nombre, List<Articulo> articuloList) {
        super(entityId);
        this.nombre = nombre;
        this.articuloList = articuloList;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public List<Articulo> ArticuloList() {
        return articuloList;
    }
}
