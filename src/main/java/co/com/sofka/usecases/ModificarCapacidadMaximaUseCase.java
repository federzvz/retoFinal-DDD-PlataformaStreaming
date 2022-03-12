package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.command.ModificarCapacidadMaxima;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.command.CambiarCostoPaquete;

public class ModificarCapacidadMaximaUseCase extends UseCase<RequestCommand<ModificarCapacidadMaxima>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarCapacidadMaxima> modificarCapacidadMaximaRequestCommand) {
        var command = modificarCapacidadMaximaRequestCommand.getCommand();
        var espectaculo = Espectaculo.from(command.getEspectaculoID(), retrieveEvents(command.getEspectaculoID().value()));
        espectaculo.modificarCapacidadMaxima(
                command.getEspectaculoID(),
                command.getCapacidadMaxima()
        );
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));
    }
}
