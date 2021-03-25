package com.reactor.operador.transformacion;

import com.reactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static reactor.core.publisher.Mono.just;

public class Transformacion {
    private static final Logger Log= LoggerFactory.getLogger(Transformacion.class);

    public void map() {
        /*List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .map(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return p;
                })
                .subscribe(p -> Log.info(p.toString()));*/

        Flux<Integer> fx = Flux.range(0 , 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(p -> Log.info("X : " + p));

    }

    public void flatMap() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .flatMap(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return Mono.just(p);
                })
                .subscribe(p -> Log.info(p.toString()));

    }

    public void groupBy() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(1, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .groupBy(Persona::getIdPersona)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> Log.info(x.toString()));

    }

}
