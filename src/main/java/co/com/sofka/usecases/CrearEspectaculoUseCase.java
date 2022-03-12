package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.command.CrearEspectaculo;

public class CrearEspectaculoUseCase extends UseCase<RequestCommand<CrearEspectaculo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEspectaculo> input) {
        CrearEspectaculo crearEspectaculo = input.getCommand();

        Espectaculo espectaculo = new Espectaculo(crearEspectaculo.getEspectaculoID(),
                crearEspectaculo.getOrganizadorID(),
                crearEspectaculo.getPremioID(),
                crearEspectaculo.getPlataformaID());
        emit().onResponse(new ResponseEvents(espectaculo.getUncommittedChanges()));

    }
}
