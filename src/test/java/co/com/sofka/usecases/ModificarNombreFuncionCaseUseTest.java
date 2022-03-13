package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.espectaculo.command.ModificarFechaRegistro;
import co.com.sofka.domain.espectaculo.event.EspectaculoCreado;
import co.com.sofka.domain.espectaculo.event.FechaRegistroModificada;
import co.com.sofka.domain.espectaculo.value.*;
import co.com.sofka.domain.funcion.command.ModificarNombreFuncion;
import co.com.sofka.domain.funcion.event.FuncionCreada;
import co.com.sofka.domain.funcion.event.NombreFuncionModificado;
import co.com.sofka.domain.funcion.value.ArtistaID;
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
class ModificarNombreFuncionCaseUseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Modificar nombre de funcion.")
    public void modificarNombreFuncion(){
        //arrage
        var command = new ModificarNombreFuncion(
                FuncionID.of(1),
                new Nombre("Nuevo$Nombre:D")
        );

        var modificarNombreFuncionCaseUse = new ModificarNombreFuncionCaseUse();

        when(repository.getEventsBy("1")).thenReturn(events());
        modificarNombreFuncionCaseUse.addRepository(repository);

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(modificarNombreFuncionCaseUse, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        var event = (NombreFuncionModificado)response.getDomainEvents().get(0);

        Assertions.assertEquals("Nuevo$Nombre:D",event.getNombre().Nombre());
        Assertions.assertEquals("funcion.nombrefuncionmodificado",event.type);

    }
    private List<DomainEvent> events(){
        return List.of(new FuncionCreada(
                new ArtistaID(1),
                new PatrocinadorID(1)
        ));
    }
}