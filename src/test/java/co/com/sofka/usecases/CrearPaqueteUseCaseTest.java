package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.paquete.command.CrearPaquete;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearPaqueteUseCaseTest {

    @Test
    void CrearPaquete(){
        //arrange
        PaqueteID paqueteID = PaqueteID.of(1);
        BecaID becaID = BecaID.of(1);
        var command = new CrearPaquete(paqueteID, becaID);
        var usecase = new CrearPaqueteUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (PaqueteCreado)events.get(0);
        Assertions.assertEquals("paquete.paquetecreado", event.type);
        Assertions.assertEquals("1", event.getBecaID().value());
        Assertions.assertEquals("1", event.aggregateRootId());
    }

}