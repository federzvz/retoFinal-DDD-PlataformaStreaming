package co.com.sofka.domain.funcion;

import co.com.sofka.domain.funcion.event.FuncionCreada;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class FuncionEventChange extends EventChange {
    public FuncionEventChange(Funcion funcion) {

        apply((FuncionCreada event) -> {
            funcion.artistaID=event.getArtistaID();
            funcion.patrocinadorID=event.getPatrocinadorID();
            funcion.espectadorList=new ArrayList<>();
        });
    }
}
