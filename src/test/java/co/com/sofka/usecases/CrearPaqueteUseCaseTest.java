package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.paquete.command.CrearPaquete;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearPaqueteUseCaseTest {

    @Test
    void CrearPaquete(){
        //arrange
        PaqueteID paqueteID = PaqueteID.of(1);
        BecaID becaID = BecaID.of(1);
        Nombre nombre = new Nombre("NombreDePrueba");
        Costo costo = new Costo(500.0,"USD");
        var command = new CrearPaquete(paqueteID, becaID,nombre,costo);
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
        Assertions.assertEquals("NombreDePrueba", event.getNombre().Nombre());
        Assertions.assertEquals("1", event.aggregateRootId());
    }

}