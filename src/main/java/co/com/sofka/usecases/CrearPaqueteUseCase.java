package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.command.CrearPaquete;

public class CrearPaqueteUseCase extends UseCase<RequestCommand<CrearPaquete>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPaquete> input) {
        CrearPaquete crearPaquete = input.getCommand();

        Paquete paquete = new Paquete(crearPaquete.getPaqueteID(), crearPaquete.getBecaID(), crearPaquete.getNombre(), crearPaquete.getCosto());
        emit().onResponse(new ResponseEvents(paquete.getUncommittedChanges()));

    }
}
