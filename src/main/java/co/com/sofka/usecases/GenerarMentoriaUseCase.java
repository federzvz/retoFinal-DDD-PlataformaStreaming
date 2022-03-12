package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.command.GenerarMentoria;
import co.com.sofka.domain.paquete.event.MentoriaGenerada;

public class GenerarMentoriaUseCase extends UseCase<RequestCommand<GenerarMentoria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<GenerarMentoria> input) {
        var command = input.getCommand();

        var paquete = Paquete.from(command.getPaqueteID(), retrieveEvents());
        if(paquete.MentoriaList().size() >= 5){//regla de negocio
            throw new BusinessException(command.getPaqueteID().value(), "No se puede agregar mas de 5 Mentorias por Paquete.");
        }
        paquete.generarMentoria(command.getMentoriaID(), command.getPaqueteID(), command.getDuracion(),command.getEspecializacion());

        emit().onResponse(new ResponseEvents(paquete.getUncommittedChanges()));

    }
}
