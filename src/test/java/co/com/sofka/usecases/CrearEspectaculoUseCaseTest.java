package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.command.CrearEspectaculo;
import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.espectaculo.value.OrganizadorID;
import co.com.sofka.domain.espectaculo.value.PlataformaID;
import co.com.sofka.domain.espectaculo.value.PremioID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearEspectaculoUseCaseTest {

    @Test
    void CrearEspectaculo(){
        //arrange
        EspectaculoID espectaculoID = EspectaculoID.of(1);
        OrganizadorID organizadorID = OrganizadorID.of(1);
        PremioID premioID = PremioID.of(1);
        PlataformaID plataformaID = PlataformaID.of(1);

        var command = new CrearEspectaculo(espectaculoID, organizadorID, premioID, plataformaID);
        var usecase = new CrearEspectaculoUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (EspectaculoCreado)events.get(0);
        Assertions.assertEquals("espectaculo.espectaculocreado", event.type);
        Assertions.assertEquals("1", event.getOrganizadorID().value());
        Assertions.assertEquals("1", event.getPremioID().value());
        Assertions.assertEquals("1", event.getPlataformaID().value());
        Assertions.assertEquals("1", event.aggregateRootId());
    }

}