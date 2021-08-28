package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class C11TestMonoWithFlatMapMany {

    public static void main(String[] args) throws InterruptedException {

        Flux<String> flatMapMany = new C11TestMonoWithFlatMapMany().flatMapMany();

        flatMapMany.subscribe(name -> {
            System.out.println("name = " + name);
        });
    }

    public Flux<String> flatMapMany() {
        return Mono.just("mafei")
                .map(String::toUpperCase)
                .flatMapMany(this::splitString)
                .log();
    }

    public Flux<String> splitString(String name) {
        String[] splitName = name.split("");
        return Flux.fromArray(splitName);
    }
}
