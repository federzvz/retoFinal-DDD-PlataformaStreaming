package co.com.sofka.domain.espectaculo;

import co.com.sofka.domain.espectaculo.event.*;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.paquete.event.CostoPaqueteModificado;

import java.util.ArrayList;

public class EspectaculoEventChange extends EventChange {
    public EspectaculoEventChange(Espectaculo espectaculo){
        apply((EspectaculoCreado event) -> {
            espectaculo.organizadorID=event.getOrganizadorID();
            espectaculo.premioID=event.getPremioID();
            espectaculo.plataformaID=event.getPlataformaID();
            espectaculo.funcionList=new ArrayList<>();
        });

        apply((CapacidadMaximaModificada event) -> espectaculo.capacidadMaxima = event.getCapacidadMaxima());

        apply((CapacidadMinimaModificada event) -> espectaculo.capacidadMinima = event.getCapacidadMinima());

        apply((CostoEspectaculoModificado event) -> espectaculo.costo = event.getCosto());

        apply((DuracionEspectaculoModificada event) -> espectaculo.duracion = event.getDuracion());

        apply((FechaRegistroModificada event) -> espectaculo.fechaRegistro = event.getFechaRegistro());

        apply((FuncionesAgregadas event) -> espectaculo.funcionList = event.getFuncionList());
    }
}