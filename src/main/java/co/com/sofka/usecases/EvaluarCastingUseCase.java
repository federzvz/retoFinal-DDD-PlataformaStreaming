/*package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.paquete.Casting;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.command.CrearPaquete;
import co.com.sofka.domain.paquete.command.EvaluarCasting;

public class EvaluarCastingUseCase extends UseCase<RequestCommand<EvaluarCasting>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EvaluarCasting> input) {
        EvaluarCasting evaluarCasting = input.getCommand();

        Casting casting = new Casting(evaluarCasting.getCastingID(),evaluarCasting.getEvaluacion());
        emit().onResponse(new ResponseEvents(casting.getUncommittedChanges()));
    }
}*/
