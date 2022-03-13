package co.com.sofka.domain.funcion;

import co.com.sofka.domain.espectaculo.event.FuncionesAgregadas;
import co.com.sofka.domain.funcion.event.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class FuncionEventChange extends EventChange {
    public FuncionEventChange(Funcion funcion) {

        apply((FuncionCreada event) -> {
            funcion.artistaID=event.getArtistaID();
            funcion.patrocinadorID=event.getPatrocinadorID();
            funcion.espectadorList=new ArrayList<>();
        });

        apply((NombreFuncionModificado event) -> funcion.nombre = event.getNombre());

        apply((FechaInicioAsignada event) -> funcion.fechaInicio = event.getFechaInicio());

        apply((HoraInicioAsignada event) -> funcion.horaInicio = event.getHoraInicio());

        apply((EspectadoresAsignados event) -> funcion.espectadorList = event.getEspectadorList());
    }
}
