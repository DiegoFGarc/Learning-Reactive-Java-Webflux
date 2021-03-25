package com.reactor;

import com.reactor.model.Persona;
import com.reactor.operador.creacion.Creacion;
import com.reactor.operador.transformacion.Transformacion;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor() {
		Mono.just(new Persona(1, "Diego", 23))
				.doOnNext(p -> log.info("[Reactor] Persona: " + p))
				.subscribe(p -> log.info("[Reactor] Persona: " + p));
	}

	public void rxjava2() {
		Observable.just(new Persona(1, "Diego", 23))
				.doOnNext(p -> log.info("[RxJava2] Persona: " + p))
				.subscribe(p -> log.info("[RxJava2] Persona: " + p));

	}

	public void mono() {
		Mono.just(new Persona(1,"Mito", 30)).subscribe(p -> log.info(p.toString()));
	}

	public void flux() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Candy", 9));
		personas.add(new Persona(2, "Marcela", 19));
		personas.add(new Persona(3, "Sarmelita", 29));

		Flux.fromIterable(personas).subscribe(p -> log.info(p.toString()));
	}

	public void fluxMono() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Candy", 9));
		personas.add(new Persona(2, "Marcela", 19));
		personas.add(new Persona(3, "Sarmelita", 29));

		Flux<Persona> fx = Flux.fromIterable(personas);
		fx.collectList().subscribe(lista -> log.info(lista.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//mono();
		//flux();
		//fluxMono();
		//Creacion app = new Creacion();
		//app.range();
		//app.repeat();
		Transformacion app = new Transformacion();
		app.groupBy();
	}

}
