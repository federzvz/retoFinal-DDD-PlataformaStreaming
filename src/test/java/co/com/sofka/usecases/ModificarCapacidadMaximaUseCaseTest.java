package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.command.ModificarCapacidadMaxima;
import co.com.sofka.domain.espectaculo.event.CapacidadMaximaModificada;
import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.espectaculo.value.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarCapacidadMaximaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar funcionalidad de modificar CapacidadMaxima de Espectáculo.")
    public void modificarCapacidadMaxima(){
        //arrage
        var command = new ModificarCapacidadMaxima(
                EspectaculoID.of(1),
                new CapacidadMaxima(500)
        );

        var modificarCapacidadMaximaUseCase = new ModificarCapacidadMaximaUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        modificarCapacidadMaximaUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(modificarCapacidadMaximaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (CapacidadMaximaModificada)response.getDomainEvents().get(0);

        Assertions.assertEquals(500,event.getCapacidadMaxima().Capacidad());
        Assertions.assertEquals("espectaculo.capacidadmaximamodificada",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new EspectaculoCreado(
                new OrganizadorID(1),
                new PremioID(1),
                new PlataformaID(1)
        ));
    }

}