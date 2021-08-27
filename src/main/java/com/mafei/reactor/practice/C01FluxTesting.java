package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;

public class C01FluxTesting {

    public static void main(String[] args) {
        namesFlux().subscribe(s -> System.out.println("s = " + s));
    }

    public static Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("mafei", "akil", "asam", "raman"));
    }
}
