package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.command.AgregarFuncionesAEspectaculo;
import co.com.sofka.domain.espectaculo.command.ModificarCostoEspectaculo;
import co.com.sofka.domain.espectaculo.event.CostoEspectaculoModificado;
import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.espectaculo.event.FuncionesAgregadas;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.espectaculo.value.OrganizadorID;
import co.com.sofka.domain.espectaculo.value.PlataformaID;
import co.com.sofka.domain.espectaculo.value.PremioID;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.funcion.value.ArtistaID;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.funcion.value.PatrocinadorID;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarFuncionesAEspectaculoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Funciones a un Espectaculo.")
    public void agregarFuncion(){
        //arrage
        var command = new AgregarFuncionesAEspectaculo(
                EspectaculoID.of(1),
                new Funcion(new FuncionID(1),new ArtistaID(1), new PatrocinadorID(1))
        );

        var agregarFuncionesAEspectaculoUseCase = new AgregarFuncionesAEspectaculoUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        agregarFuncionesAEspectaculoUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(agregarFuncionesAEspectaculoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (FuncionesAgregadas)response.getDomainEvents().get(0);
        Assertions.assertEquals(EspectaculoID.of(1),event.getEspectaculoID());
        Assertions.assertEquals("espectaculo.funcionesagregadas",event.type);

    }

    private List<DomainEvent> events(){
        return List.of(new EspectaculoCreado(
                new OrganizadorID(1),
                new PremioID(1),
                new PlataformaID(1)
        ));
    }
}