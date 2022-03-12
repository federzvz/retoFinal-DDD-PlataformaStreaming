package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.command.ModificarDuracionEspectaculo;

public class ModificarDuracionEspectaculoUseCase extends UseCase<RequestCommand<ModificarDuracionEspectaculo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarDuracionEspectaculo> modificarDuracionEspectaculoRequestCommand) {
        var command = modificarDuracionEspectaculoRequestCommand.getCommand();
        var espectaculo = Espectaculo.from(command.getEspectaculoID(), retrieveEvents(command.getEspectaculoID().value()));
        espectaculo.modificarDuracion(
                command.getEspectaculoID(),
                command.getDuracion()
        );
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));
    }
}
