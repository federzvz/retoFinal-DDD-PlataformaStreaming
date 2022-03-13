package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.funcion.command.AsignarFechaInicio;
import co.com.sofka.domain.funcion.command.AsignarHoraInicio;
import co.com.sofka.domain.funcion.event.FechaInicioAsignada;
import co.com.sofka.domain.funcion.event.FuncionCreada;
import co.com.sofka.domain.funcion.event.HoraInicioAsignada;
import co.com.sofka.domain.funcion.value.*;
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
class AsignarHoraInicioUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Asignar HoraInicio a una Funcion")
    public void asignarHoraInicio(){
        //arrage
        var command = new AsignarHoraInicio(
                FuncionID.of(1),
                new HoraInicio(15,0)
        );

        var asignarHoraInicioUseCase = new AsignarHoraInicioUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        asignarHoraInicioUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(asignarHoraInicioUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (HoraInicioAsignada)response.getDomainEvents().get(0);

        Assertions.assertEquals(15,event.getHoraInicio().value().hora());
        Assertions.assertEquals(0,event.getHoraInicio().value().minuto());
        Assertions.assertEquals("funcion.horainicioasignada",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new FuncionCreada(
                new ArtistaID(1),
                new PatrocinadorID(1)
        ));
    }
}