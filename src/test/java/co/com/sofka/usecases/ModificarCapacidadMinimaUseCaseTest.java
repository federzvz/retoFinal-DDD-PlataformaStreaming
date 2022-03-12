package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.command.ModificarCapacidadMinima;
import co.com.sofka.domain.espectaculo.event.CapacidadMinimaModificada;
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
class ModificarCapacidadMinimaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar funcionalidad de modificar CapacidadMinima de Espectáculo.")
    public void modificarCapacidadMinima(){
        //arrage
        var command = new ModificarCapacidadMinima(
                EspectaculoID.of(1),
                new CapacidadMinima(200)
        );

        var modificarCapacidadMinimaUseCase = new ModificarCapacidadMinimaUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        modificarCapacidadMinimaUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(modificarCapacidadMinimaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (CapacidadMinimaModificada)response.getDomainEvents().get(0);

        Assertions.assertEquals(200,event.getCapacidadMinima().Capacidad());
        Assertions.assertEquals("espectaculo.capacidadminimamodificada",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new EspectaculoCreado(
                new OrganizadorID(1),
                new PremioID(1),
                new PlataformaID(1)
        ));
    }

}