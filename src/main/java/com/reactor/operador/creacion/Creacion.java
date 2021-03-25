package com.reactor.operador.creacion;

import com.reactor.model.Persona;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {

    private static final Logger Log= LoggerFactory.getLogger(Creacion.class);

    public void JustFrom() {
        Mono.just(new Persona(1,"Diego", 23));
        //Flux.fromIterable(coleccion);
        //Observable.just(item);
    }

    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range() {
        Flux.range(0, 3)
                .doOnNext(i -> Log.info("i : "+ i))
                .subscribe();
    }

    public void repeat(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        /*Flux.fromIterable(personas)
                .repeat(3)
                .subscribe(p -> Log.info(p.toString()));*/

        Mono.just(new Persona(1, "Jeimy", 23))
                .repeat(3)
                .subscribe(p -> Log.info(p.toString()));
    }

}
