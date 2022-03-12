package co.com.sofka.generic.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Costo implements ValueObject<Costo.Props> {
    private final Double valor;
    private final String moneda;

    public Costo(){
        this.valor=0.0;
        this.moneda="USD";
    }

    public Costo(Double valor, String moneda) {
        this.valor = Objects.requireNonNull(valor);
        this.moneda = Objects.requireNonNull(moneda);

        if (valor < 0) {
            throw new IllegalArgumentException("El valor del costo no puede ser negativo.");
        }
    }

    @Override
    public Costo.Props value() {
        return new Costo.Props() {
            @Override
            public Double valor() {
                return valor;
            }

            @Override
            public String moneda() {
                return moneda;
            }
        };
    }

    public interface Props{
        Double valor();
        String moneda();
    }

}
