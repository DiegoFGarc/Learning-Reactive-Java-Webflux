package com.reactor.operador.filtrado;

import com.reactor.model.Persona;
import com.reactor.operador.transformacion.Transformacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {

    private static final Logger Log= LoggerFactory.getLogger(Transformacion.class);

    public void filter() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 28)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void distinct() {

        Flux.fromIterable(List.of(1,1,2,2))
                .distinct()
                .subscribe(p -> Log.info(p.toString()));

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> Log.info(p.toString()));
    }

    public void take() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .take(2)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void takeLast() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .takeLast(1)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void skip() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .skip(1)
                .subscribe(p -> Log.info(p.toString()));
    }

    public void skipLast() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .skipLast(1)
                .subscribe(p -> Log.info(p.toString()));
    }

}
