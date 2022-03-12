package co.com.sofka.domain.espectaculo.command;

import co.com.sofka.domain.espectaculo.value.EspectaculoID;
import co.com.sofka.domain.funcion.Funcion;
import co.com.sofka.domain.generic.Command;

import java.util.ArrayList;
import java.util.List;

public class AgregarFuncionesAEspectaculo extends Command {
    private EspectaculoID espectaculoID;
    private List<Funcion> functionList = new ArrayList<>();
    private Funcion funcion;

    public AgregarFuncionesAEspectaculo(EspectaculoID espectaculoID, Funcion funcion) {
        if(funcion==null){
            throw new IllegalArgumentException("Funcion es Null");
        }
        this.espectaculoID = espectaculoID;
        this.funcion=funcion;
        this.functionList.add(funcion);
    }

    public EspectaculoID getEspectaculoID() {
        return espectaculoID;
    }

    public List<Funcion> getFunctionList() {
        return functionList;
    }

    public Funcion getFuncion() {
        return funcion;
    }
}
