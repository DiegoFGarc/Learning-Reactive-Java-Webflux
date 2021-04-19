package com.reactor.operador.combinacion;

import com.reactor.model.Persona;
import com.reactor.model.Venta;
import com.reactor.operador.transformacion.Transformacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combinacion {

    private static final Logger Log= LoggerFactory.getLogger(Transformacion.class);
    //Hace la combinación entre dos flujos de datos CONCATENAR
    public void merge(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "DiegoFer", 21));
        personas1.add(new Persona(2, "Fernando", 20));
        personas1.add(new Persona(3, "Garcia", 211));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx = Flux.fromIterable(personas);
        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Venta> fx2 = Flux.fromIterable(ventas);

        Flux.merge(fx,fx1,fx2)
                .subscribe(p -> Log.info(p.toString()));

    }
    //Concatena uniendo los flujos de datos con informaciòn alterada o los deja en una sola línea
    public void zip(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "DiegoFer", 21));
        personas1.add(new Persona(2, "Fernando", 20));
        personas1.add(new Persona(3, "Garcia", 211));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx = Flux.fromIterable(personas);
        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Venta> fx2 = Flux.fromIterable(ventas);

        /*Flux.zip(fx, fx1,(p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
        .subscribe(x -> Log.info(x));*/

        Flux.zip(fx, fx1, fx2)
                .subscribe(x -> Log.info(x.toString()));

    }

    public void zipWith(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "DiegoFer", 21));
        personas.add(new Persona(2, "Fernando", 20));
        personas.add(new Persona(3, "Garcia", 211));

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "DiegoFer", 21));
        personas1.add(new Persona(2, "Fernando", 20));
        personas1.add(new Persona(3, "Garcia", 211));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx = Flux.fromIterable(personas);
        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Venta> fx2 = Flux.fromIterable(ventas);

        fx.zipWith(fx1, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(x -> Log.info(x.toString()));
    }



}
