package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.funcion.command.CrearFuncion;

public class CrearFuncionUseCase extends UseCase<RequestCommand<CrearFuncion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFuncion> input) {
        CrearFuncion crearFuncion = input.getCommand();

        Funcion funcion = new Funcion(crearFuncion.getFuncionID(),
                crearFuncion.getArtistaID(),
                crearFuncion.getPatrocinadorID());
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));

    }
}
