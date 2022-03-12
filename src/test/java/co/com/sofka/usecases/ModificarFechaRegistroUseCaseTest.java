package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.command.ModificarFechaRegistro;
import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.espectaculo.event.FechaRegistroModificada;
import co.com.sofka.domain.espectaculo.value.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarFechaRegistroUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar funcionalidad de modificar FechaRegistro de Espectáculo.")
    public void modificarFechaRegistro(){
        //arrage
        var command = new ModificarFechaRegistro(
                EspectaculoID.of(1),
                new FechaRegistro()
        );

        var modificarFechaRegistroUseCase = new ModificarFechaRegistroUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        modificarFechaRegistroUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(modificarFechaRegistroUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (FechaRegistroModificada)response.getDomainEvents().get(0);

        Assertions.assertEquals(LocalDate.now(),event.getFechaRegistro().value());
        Assertions.assertEquals("espectaculo.fecharegistromodificada",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new EspectaculoCreado(
                new OrganizadorID(1),
                new PremioID(1),
                new PlataformaID(1)
        ));
    }
}