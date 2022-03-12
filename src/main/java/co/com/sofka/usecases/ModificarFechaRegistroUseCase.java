package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.command.ModificarFechaRegistro;

public class ModificarFechaRegistroUseCase extends UseCase<RequestCommand<ModificarFechaRegistro>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarFechaRegistro> modificarFechaRegistroRequestCommand) {
        var command = modificarFechaRegistroRequestCommand.getCommand();
        var espectaculo = Espectaculo.from(command.getEspectaculoID(), retrieveEvents(command.getEspectaculoID().value()));
        espectaculo.modificarFechaRegistro(
                command.getEspectaculoID(),
                command.getFechaRegistro()
        );
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));
    }
}
