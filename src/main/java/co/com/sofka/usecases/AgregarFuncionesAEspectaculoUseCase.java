package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.command.AgregarFuncionesAEspectaculo;
import co.com.sofka.domain.espectaculo.command.ModificarCostoEspectaculo;

public class AgregarFuncionesAEspectaculoUseCase extends UseCase<RequestCommand<AgregarFuncionesAEspectaculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarFuncionesAEspectaculo> agregarFuncionesAEspectaculoRequestCommand) {
        var command = agregarFuncionesAEspectaculoRequestCommand.getCommand();
        var espectaculo = Espectaculo.from(command.getEspectaculoID(), retrieveEvents(command.getEspectaculoID().value()));
        espectaculo.agregarFunciones(
                command.getEspectaculoID(),
                command.getFuncion()
        );
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));
    }
}
