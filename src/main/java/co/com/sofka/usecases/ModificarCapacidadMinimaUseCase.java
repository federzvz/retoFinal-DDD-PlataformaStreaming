package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.command.ModificarCapacidadMaxima;
import co.com.sofka.domain.espectaculo.command.ModificarCapacidadMinima;

public class ModificarCapacidadMinimaUseCase extends UseCase<RequestCommand<ModificarCapacidadMinima>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarCapacidadMinima> modificarCapacidadMinimaRequestCommand) {
        var command = modificarCapacidadMinimaRequestCommand.getCommand();
        var espectaculo = Espectaculo.from(command.getEspectaculoID(), retrieveEvents(command.getEspectaculoID().value()));
        espectaculo.modificarCapacidadMinima(
                command.getEspectaculoID(),
                command.getCapacidadMinima()
        );
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));
    }
}
