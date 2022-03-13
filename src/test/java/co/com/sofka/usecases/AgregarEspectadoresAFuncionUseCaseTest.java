package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.funcion.Espectador;
import co.com.sofka.domain.funcion.command.AsignarEspectadoresAFuncion;
import co.com.sofka.domain.funcion.command.AsignarFechaInicio;
import co.com.sofka.domain.funcion.event.EspectadoresAsignados;
import co.com.sofka.domain.funcion.event.FechaInicioAsignada;
import co.com.sofka.domain.funcion.event.FuncionCreada;
import co.com.sofka.domain.funcion.value.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.value.Email;
import co.com.sofka.generic.value.Nacimiento;
import co.com.sofka.generic.value.Nickname;
import co.com.sofka.generic.value.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEspectadoresAFuncionUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Espectador a Funcion")
    public void agregarEspectadorAFuncion(){
        //arrage
        var command = new AsignarEspectadoresAFuncion(
                FuncionID.of(1),
                new Espectador(new EspectadorID(1),
                        new Nickname("testNickName"),
                        new Nombre("Nombre ParaProbar"),
                        new Email("emailDePrueba@gmail.com"),
                        new Nacimiento(new SimpleDateFormat("2001-01-18"))
                        )
        );

        var agregarEspectadoresAFuncionUseCase = new AgregarEspectadoresAFuncionUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        agregarEspectadoresAFuncionUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(agregarEspectadoresAFuncionUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (EspectadoresAsignados)response.getDomainEvents().get(0);

        Assertions.assertEquals(FuncionID.of(1),event.getFuncionID());
        Assertions.assertEquals("funcion.espectadoresasignados",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new FuncionCreada(
                new ArtistaID(1),
                new PatrocinadorID(1)
        ));
    }
}