package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.funcion.command.AsignarFechaInicio;
import co.com.sofka.domain.funcion.command.AsignarHoraInicio;

public class AsignarHoraInicioUseCase extends UseCase<RequestCommand<AsignarHoraInicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarHoraInicio> asignarHoraInicioRequestCommand) {
        var command = asignarHoraInicioRequestCommand.getCommand();
        var funcion = Funcion.from(command.getFuncionID(), retrieveEvents(command.getFuncionID().value()));
        funcion.asignarHoraInicio(
                command.getFuncionID(),
                command.getHoraInicio()
        );
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}
