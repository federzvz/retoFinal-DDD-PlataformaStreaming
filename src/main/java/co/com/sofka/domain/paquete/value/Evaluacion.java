package co.com.sofka.domain.paquete.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Evaluacion implements ValueObject<Evaluacion.Props> {
    private final Integer notaJurados;
    private final Integer notaPublico;
    private final boolean isAprobado;

    public Evaluacion(Integer notaJurados, Integer notaPublico) {
        this.notaJurados = Objects.requireNonNull(notaJurados);
        this.notaPublico = Objects.requireNonNull(notaPublico);

        if(notaJurados<1){
            throw new IllegalArgumentException("La nota del jurado no puede ser menor que 1.");
        }
        if(notaJurados>12){
            throw new IllegalArgumentException("La nota del jurado no puede ser mayor que 12.");
        }
        if(notaPublico<1){
            throw new IllegalArgumentException("La nota del público no puede ser menor que 1.");
        }
        if(notaPublico>12){
            throw new IllegalArgumentException("La nota del público no puede ser mayor que 12.");
        }

        if(((notaJurados+notaPublico)/2) < 6){
            this.isAprobado=false;
        }else{
            this.isAprobado=true;
        }
    }

    @Override
    public Evaluacion.Props value() {
        return new Evaluacion.Props() {
            @Override
            public Integer notaJurados() {
                return notaJurados;
            }

            @Override
            public Integer notaPublico() {
                return notaPublico;
            }

            @Override
            public Boolean isAprobado() {
                return isAprobado;
            }
        };
    }

    public interface Props{
        Integer notaJurados();
        Integer notaPublico();
        Boolean isAprobado();
    }
}
