package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.paquete.command.GenerarMentoria;
import co.com.sofka.domain.paquete.event.MentoriaGenerada;
import co.com.sofka.domain.paquete.event.PaqueteCreado;
import co.com.sofka.domain.paquete.value.BecaID;
import co.com.sofka.domain.paquete.value.Especializacion;
import co.com.sofka.domain.paquete.value.MentoriaID;
import co.com.sofka.domain.paquete.value.PaqueteID;
import co.com.sofka.generic.value.Costo;
import co.com.sofka.generic.value.Duracion;
import co.com.sofka.generic.value.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GenerarMentoriaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void generarMentoria(){
        //arrange
        MentoriaID mentoriaID = MentoriaID.of(1);
        PaqueteID paqueteID = PaqueteID.of(1);
        Duracion duracion = new Duracion(10);
        Especializacion especializacion = new Especializacion("IA");
        var command = new GenerarMentoria(mentoriaID,paqueteID,duracion,especializacion);
        Mockito.when(repository.getEventsBy("paquete","1")).thenReturn(history());

        var usecase = new GenerarMentoriaUseCase();
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(paqueteID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (MentoriaGenerada)events.get(0);
        Assertions.assertEquals("paquete.becagenerada", event.type);
        Assertions.assertEquals(1, event.getDuracion().value());
        Assertions.assertEquals("IA", event.getEspecializacion().Especializacion());
    }

    private List<DomainEvent> history() {
        return List.of(
                new PaqueteCreado(BecaID.of(1),new Nombre("NombreDePrueba"),new Costo(250.0,"USD")),
                new MentoriaGenerada(MentoriaID.of(1), PaqueteID.of(1), new Duracion(20), new Especializacion("IA"))
        );
    }


}