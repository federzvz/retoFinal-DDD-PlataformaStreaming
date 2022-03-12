package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.command.GenerarBeca;
import co.com.sofka.domain.paquete.event.BecaGenerada;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.Bono;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GenerarBecaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void generarBeca(){
        //arrange
        PaqueteID paqueteID = PaqueteID.of(1);
        Bono bono = new Bono(250.0,3);
        var command = new GenerarBeca(paqueteID,bono);
        Mockito.when(repository.getEventsBy("1")).thenReturn(events());

        var usecase = new GenerarBecaUseCase();
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (BecaGenerada)events.get(0);
        Assertions.assertEquals("paquete.becagenerada", event.type);
        Assertions.assertEquals(250.0, event.getBono().value().cuotaValor());
        Assertions.assertEquals(3, event.getBono().value().meses());
    }

    private List<DomainEvent> events() {
        return List.of(new PaqueteCreado(BecaID.of(1),new Nombre("NombreDePrueba"),new Costo(500.0,"USD")));
    }
}