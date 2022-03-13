package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.funcion.command.AsignarFechaInicio;

public class AsignarFechaInicioUseCase extends UseCase<RequestCommand<AsignarFechaInicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarFechaInicio> asignarFechaInicioRequestCommand) {
        var command = asignarFechaInicioRequestCommand.getCommand();
        var funcion = Funcion.from(command.getFuncionID(), retrieveEvents(command.getFuncionID().value()));
        funcion.asignarFechaInicio(
                command.getFuncionID(),
                command.getFechaInicio()
        );
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}
