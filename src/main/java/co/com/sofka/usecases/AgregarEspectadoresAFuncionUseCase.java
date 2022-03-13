package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.funcion.command.AsignarEspectadoresAFuncion;
import co.com.sofka.domain.funcion.command.AsignarFechaInicio;

public class AgregarEspectadoresAFuncionUseCase extends UseCase<RequestCommand<AsignarEspectadoresAFuncion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarEspectadoresAFuncion> asignarEspectadoresAFuncionRequestCommand) {
        var command = asignarEspectadoresAFuncionRequestCommand.getCommand();
        var funcion = Funcion.from(command.getFuncionID(), retrieveEvents(command.getFuncionID().value()));
        funcion.agregarEspectador(
                command.getFuncionID(),
                command.getEspectador()
        );
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}
