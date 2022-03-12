package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.command.CambiarCostoPaquete;
import co.com.sofka.domain.paquete.event.CostoPaqueteModificado;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarCostoPaqueteUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar funcionalidad de cambiar Costo de Producto.")
    public void cambiarCosto(){
        //arrage
        var command = new CambiarCostoPaquete(
                PaqueteID.of(1),
                new Costo(250.0,"USD")
        );

        var cambiarCostoPaqueteUseCase = new CambiarCostoPaqueteUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        cambiarCostoPaqueteUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(cambiarCostoPaqueteUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (CostoPaqueteModificado)response.getDomainEvents().get(0);

        Assertions.assertEquals(250.0,event.getCosto().value().valor());
        Assertions.assertEquals("paquete.costomodificado",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new PaqueteCreado(
                new BecaID(1),
                new Nombre(("PaqueteUno")),
                new Costo(500.0,"USD")
        ));
    }

}