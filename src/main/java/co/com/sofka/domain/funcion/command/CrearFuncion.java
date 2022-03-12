package co.com.sofka.domain.funcion.command;

import co.com.sofka.domain.funcion.value.ArtistaID;
import co.com.sofka.domain.funcion.value.FuncionID;
import co.com.sofka.domain.funcion.value.PatrocinadorID;
import co.com.sofka.domain.generic.Command;

public class CrearFuncion extends Command {
    private final FuncionID funcionID;
    private final ArtistaID artistaID;
    private final PatrocinadorID patrocinadorID;

    public CrearFuncion(FuncionID funcionID, ArtistaID artistaID, PatrocinadorID patrocinadorID) {
        this.funcionID = funcionID;
        this.artistaID = artistaID;
        this.patrocinadorID = patrocinadorID;
    }

    public FuncionID getFuncionID() {
        return funcionID;
    }

    public ArtistaID getArtistaID() {
        return artistaID;
    }

    public PatrocinadorID getPatrocinadorID() {
        return patrocinadorID;
    }
}
