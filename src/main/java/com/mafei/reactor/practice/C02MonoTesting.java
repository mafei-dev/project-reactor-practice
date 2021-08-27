package com.mafei.reactor.practice;

import reactor.core.publisher.Mono;

public class C02MonoTesting {

    public static void main(String[] args) {
        nameMono().subscribe(s -> System.out.println("name = " + s));
    }

    public static Mono<String> nameMono() {
        return Mono.just("mafei");
    }
}
