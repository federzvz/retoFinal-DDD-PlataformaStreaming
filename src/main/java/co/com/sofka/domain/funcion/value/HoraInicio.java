package co.com.sofka.domain.funcion.value;

import co.com.sofka.domain.espectaculo.value.Articulo;
import co.com.sofka.domain.generic.ValueObject;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class HoraInicio implements ValueObject<HoraInicio.Props> {
    private final Integer hora;
    private final Integer minuto;

    public HoraInicio(Integer hora, Integer minuto) {
        this.hora = Objects.requireNonNull(hora);
        this.minuto = Objects.requireNonNull(minuto);

        if (hora <0 || hora>23) {
            throw new IllegalArgumentException("La hora debe estar comprendida desde las 0 hasta las 23");
        }
        if (minuto <0 || minuto>59) {
            throw new IllegalArgumentException("Los minutos deben estar comprendidos entre el 0 y el 59");
        }
    }

    @Override
    public HoraInicio.Props value() {
        return new HoraInicio.Props() {
            @Override
            public Integer hora() {
                return hora;
            }

            @Override
            public Integer minuto() {
                return minuto;
            }
        };
    }

    public interface Props{
        Integer hora();
        Integer minuto();
    }
}
