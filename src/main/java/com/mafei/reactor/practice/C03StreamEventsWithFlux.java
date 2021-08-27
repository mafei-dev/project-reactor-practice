package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;

public class C03StreamEventsWithFlux {

    public static void main(String[] args) {
        new C03StreamEventsWithFlux().namesFlux().subscribe(s -> System.out.println("s = " + s));
    }

    public Flux<String> namesFlux() {
        return Flux
                .fromIterable(
                        List.of("mafei", "akil", "asam", "raman")
                )
                .log();
    }
}
