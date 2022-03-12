package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.command.ModificarCapacidadMinima;
import co.com.sofka.domain.espectaculo.command.ModificarDuracionEspectaculo;
import co.com.sofka.domain.espectaculo.event.CapacidadMinimaModificada;
import co.com.sofka.domain.espectaculo.event.DuracionEspectaculoModificada;
import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.espectaculo.value.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Duracion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarDuracionEspectaculoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar funcionalidad de modificar Duracion de Espectáculo.")
    public void modificarCapacidadMinima(){
        //arrage
        var command = new ModificarDuracionEspectaculo(
                EspectaculoID.of(1),
                new Duracion(8)
        );

        var modificarDuracionEspectaculoUseCase = new ModificarDuracionEspectaculoUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        modificarDuracionEspectaculoUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(modificarDuracionEspectaculoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (DuracionEspectaculoModificada)response.getDomainEvents().get(0);

        Assertions.assertEquals(8,event.getDuracion().Duracion());
        Assertions.assertEquals("espectaculo.duracionmodificada",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new EspectaculoCreado(
                new OrganizadorID(1),
                new PremioID(1),
                new PlataformaID(1)
        ));
    }

}