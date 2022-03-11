package co.com.sofka.domain.paquete.value;

import co.com.sofka.domain.generic.Identity;

public class MentoriaID extends Identity {
    private MentoriaID(Integer num){
        super(num.toString());
    }

    public static MentoriaID of(Integer num){
        return new MentoriaID(num);
    }
}
