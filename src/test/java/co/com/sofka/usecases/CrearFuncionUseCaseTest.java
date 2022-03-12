package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.funcion.command.CrearFuncion;
import co.com.sofka.domain.funcion.event.FuncionCreada;
import co.com.sofka.domain.funcion.value.ArtistaID;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.funcion.value.PatrocinadorID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearFuncionUseCaseTest {

    @Test
    void crearFuncion(){
        //arrange
        FuncionID funcionID = FuncionID.of(1);
        ArtistaID artistaID = ArtistaID.of(1);
        PatrocinadorID patrocinadorID = PatrocinadorID.of(1);

        var command = new CrearFuncion(funcionID, artistaID, patrocinadorID);
        var usecase = new CrearFuncionUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (FuncionCreada)events.get(0);
        Assertions.assertEquals("funcion.funcioncreada", event.type);
        Assertions.assertEquals("1", event.getArtistaID().value());
        Assertions.assertEquals("1", event.getPatrocinadorID().value());
        Assertions.assertEquals("1", event.aggregateRootId());
    }


}