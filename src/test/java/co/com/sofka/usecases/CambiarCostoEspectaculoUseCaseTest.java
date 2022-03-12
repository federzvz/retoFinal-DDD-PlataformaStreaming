package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.command.ModificarCostoEspectaculo;
import co.com.sofka.domain.espectaculo.event.CostoEspectaculoModificado;
import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.espectaculo.value.OrganizadorID;
import co.com.sofka.domain.espectaculo.value.PlataformaID;
import co.com.sofka.domain.espectaculo.value.PremioID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Costo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarCostoEspectaculoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Validar funcionalidad de modificar Costo de Espectáculo.")
    public void cambiarCosto(){
        //arrage
        var command = new ModificarCostoEspectaculo(
                EspectaculoID.of(1),
                new Costo(420.69,"USD")
        );

        var cambiarCostoEspectaculoUseCase = new CambiarCostoEspectaculoUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        cambiarCostoEspectaculoUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(cambiarCostoEspectaculoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (CostoEspectaculoModificado)response.getDomainEvents().get(0);

        Assertions.assertEquals(420.69,event.getCosto().value().valor());
        Assertions.assertEquals("espectaculo.costomodificado",event.type);

    }

    private List<DomainEvent> events(){
        return List.of(new EspectaculoCreado(
                new OrganizadorID(1),
                new PremioID(1),
                new PlataformaID(1)
        ));
    }

}