package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.command.ModificarCostoEspectaculo;

public class CambiarCostoEspectaculoUseCase extends UseCase<RequestCommand<ModificarCostoEspectaculo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarCostoEspectaculo> modificarCostoEspectaculoRequestCommand) {
        var command = modificarCostoEspectaculoRequestCommand.getCommand();
        var espectaculo = Espectaculo.from(command.getEspectaculoID(), retrieveEvents(command.getEspectaculoID().value()));
        espectaculo.modificarCosto(
                command.getEspectaculoID(),
                command.getCosto()
        );
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));
    }
}
