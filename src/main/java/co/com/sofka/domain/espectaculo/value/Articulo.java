package co.com.sofka.domain.espectaculo.value;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.domain.paquete.value.Bono;

import java.util.Objects;

public class Articulo implements ValueObject<Articulo.Props> {
    private final String nombre;
    private final String descripcion;

    public Articulo(String nombre, String descripcion) {
        this.nombre = Objects.requireNonNull(nombre);
        this.descripcion = Objects.requireNonNull(descripcion);

        if (nombre.length()<5) {
            throw new IllegalArgumentException("El nombre no puede tener menos de 5 carácteres.");
        }
        if(nombre.contains("-") ||
                nombre.contains("+") ||
                nombre.contains("^") ||
                nombre.contains(".") ||
                nombre.contains(":") ||
                nombre.contains(",") ||
                nombre.contains("!") ||
                nombre.contains("#") ||
                nombre.contains("%") ||
                nombre.contains("&") ||
                nombre.contains("/") ||
                nombre.contains("=") ||
                nombre.contains("$")
        ){
            throw new IllegalArgumentException("Un nombre no puede contener los carácteres: -+^.:,$#%&/=");
        }
        if(nombre.length()>50){
            throw new IllegalArgumentException("Un nombre no puede tener mas de 50 carácteres.");
        }
        if(descripcion.isEmpty()){
            throw new IllegalArgumentException("La descripcion no puede estar vacía.");
        }
        if(descripcion.length()>255){
            throw new IllegalArgumentException("La longitud de la descripcion del Artículo no puede superar los 255 carácteres.");
        }
    }

    @Override
    public Articulo.Props value() {
        return new Articulo.Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String descripcion() {
                return descripcion;
            }
        };
    }

    public interface Props{
        String nombre();
        String descripcion();
    }
}
