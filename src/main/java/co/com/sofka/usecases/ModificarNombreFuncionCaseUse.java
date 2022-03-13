package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.funcion.command.ModificarNombreFuncion;

public class ModificarNombreFuncionCaseUse extends UseCase<RequestCommand<ModificarNombreFuncion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarNombreFuncion> modificarNombreFuncionRequestCommand) {
        var command = modificarNombreFuncionRequestCommand.getCommand();
        var funcion = Funcion.from(command.getFuncionID(), retrieveEvents(command.getFuncionID().value()));
        funcion.modificarNombre(
                command.getFuncionID(),
                command.getNombre()
        );
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}
