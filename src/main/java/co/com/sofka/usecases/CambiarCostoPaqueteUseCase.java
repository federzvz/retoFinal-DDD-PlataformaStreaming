package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.command.CambiarCostoPaquete;

public class CambiarCostoPaqueteUseCase extends UseCase<RequestCommand<CambiarCostoPaquete>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarCostoPaquete> cambiarCostoPaqueteRequestCommand) {
        var command = cambiarCostoPaqueteRequestCommand.getCommand();
        var paquete = Paquete.from(command.getPaqueteID(), retrieveEvents(command.getPaqueteID().value()));
        paquete.modificarCosto(
                command.getPaqueteID(),
                command.getCosto()
        );
        emit().onResponse(new ResponseEvents(paquete.getUncommittedChanges()));
    }
}
