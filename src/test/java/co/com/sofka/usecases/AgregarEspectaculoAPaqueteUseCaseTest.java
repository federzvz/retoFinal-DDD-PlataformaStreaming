package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.Espectaculo;
import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.espectaculo.value.OrganizadorID;
import co.com.sofka.domain.espectaculo.value.PlataformaID;
import co.com.sofka.domain.espectaculo.value.PremioID;
import co.com.sofka.domain.funcion.Espectador;
import co.com.sofka.domain.funcion.command.AsignarEspectadoresAFuncion;
import co.com.sofka.domain.funcion.event.EspectadoresAsignados;
import co.com.sofka.domain.funcion.event.FuncionCreada;
import co.com.sofka.domain.funcion.value.ArtistaID;
import co.com.sofka.domain.funcion.value.EspectadorID;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.funcion.value.PatrocinadorID;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.Beca;
import co.com.sofka.domain.paquete.Paquete;
import co.com.sofka.domain.paquete.command.AgregarEspectaculoAPaquete;
import co.com.sofka.domain.paquete.event.EspectaculoAgregado;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEspectaculoAPaqueteUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregar Espectaculo a Paquete")
    public void agregarEspectaculoAPaquete(){
        //arrage
        var command = new AgregarEspectaculoAPaquete(
                PaqueteID.of(1),
                new Espectaculo(
                        new EspectaculoID(1),
                        new OrganizadorID(1),
                        new PremioID(1),
                        new PlataformaID(1)
                )
        );

        var agregarEspectaculoAPaqueteUseCase = new AgregarEspectaculoAPaqueteUseCase();

        when(repository.getEventsBy("1")).thenReturn(events());
        agregarEspectaculoAPaqueteUseCase.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(agregarEspectaculoAPaqueteUseCase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (EspectaculoAgregado)response.getDomainEvents().get(0);

        Assertions.assertEquals(PaqueteID.of(1),event.getPaqueteID());
        Assertions.assertEquals("paquete.espectaculoagregado",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new PaqueteCreado(
                new BecaID(1),
                new Nombre("NombreTest"),
                new Costo(420.69,"USD")
        ));
    }
}