package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.command.AgregarEspectaculoAPaquete;

public class AgregarEspectaculoAPaqueteUseCase extends UseCase<RequestCommand<AgregarEspectaculoAPaquete>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarEspectaculoAPaquete> agregarEspectaculoAPaqueteRequestCommand) {
        var command = agregarEspectaculoAPaqueteRequestCommand.getCommand();
        var paquete = Paquete.from(command.getPaqueteID(), retrieveEvents(command.getPaqueteID().value()));
        paquete.agregarEspectaculo(
                command.getPaqueteID(),
                command.getEspectaculo()
        );
        emit().onResponse(new ResponseEvents(paquete.getUncommittedChanges()));
    }
}
