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
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(1, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> Log.info(p.toString()));
    }
}
