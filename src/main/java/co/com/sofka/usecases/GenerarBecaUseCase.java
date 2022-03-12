package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.command.GenerarBeca;

public class GenerarBecaUseCase extends UseCase<RequestCommand<GenerarBeca>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<GenerarBeca> input) {
        var command = input.getCommand();

        var paquete = Paquete.from(command.getPaqueteID(), retrieveEvents());
        paquete.generarBeca(command.getBono());

        emit().onResponse(new ResponseEvents(paquete.getUncommittedChanges()));

    }
}
