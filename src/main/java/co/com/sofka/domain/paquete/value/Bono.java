package co.com.sofka.domain.paquete.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Bono implements ValueObject<Bono.Props> {
    private final Double cuotaValor;
    private final Integer meses;

    public Bono(Double cuotaValor, Integer meses) {
        this.cuotaValor = Objects.requireNonNull(cuotaValor);
        this.meses = Objects.requireNonNull(meses);

        if (cuotaValor <= 0) {
            throw new IllegalArgumentException("El valor de la cuota no puede ser menor/igual a 0.");
        }
        if(meses <1){
            throw new IllegalArgumentException("La cantidad de meses no puede ser menor a 1.");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Double cuotaValor() {
                return cuotaValor;
            }

            @Override
            public Integer meses() {
                return meses;
            }
        };
    }

    public interface Props{
        Double cuotaValor();
        Integer meses();
    }
}