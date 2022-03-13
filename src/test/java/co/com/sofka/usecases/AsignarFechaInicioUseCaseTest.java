package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.funcion.command.AsignarFechaInicio;
import co.com.sofka.domain.funcion.command.ModificarNombreFuncion;
import co.com.sofka.domain.funcion.event.FechaInicioAsignada;
import co.com.sofka.domain.funcion.event.FuncionCreada;
import co.com.sofka.domain.funcion.event.NombreFuncionModificado;
import co.com.sofka.domain.funcion.value.ArtistaID;
import co.com.sofka.domain.funcion.value.FechaInicio;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.funcion.value.PatrocinadorID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AsignarFechaInicioUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Asignar FechaInicio a una Funcion")
    public void asignarFechaInicio(){
        //arrage
        var command = new AsignarFechaInicio(
                FuncionID.of(1),
                new FechaInicio()
        );

        var asignarFechaInicioUseCase = new AsignarFechaInicioUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        asignarFechaInicioUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(asignarFechaInicioUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (FechaInicioAsignada)response.getDomainEvents().get(0);

        Assertions.assertEquals(LocalDate.now(),event.getFechaInicio().value());
        Assertions.assertEquals("funcion.fechainicioasignada",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new FuncionCreada(
                new ArtistaID(1),
                new PatrocinadorID(1)
        ));
    }
}