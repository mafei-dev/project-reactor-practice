package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;

public class C12Transform {

    //this functional function is reusable like a method.
    public static Function<Flux<String>, Flux<String>> filerAndToUpper =
            name -> name.map(String::toUpperCase)
                    .filter(s -> s.length() > 3);

    public static void main(String[] args) throws InterruptedException {

        Flux<String> flatMapMany = new C12Transform().nameFluxTransform();

        flatMapMany.subscribe(name -> {
            System.out.println("name = " + name);
        });
    }

    public Flux<String> nameFluxTransform() {
        return Flux
                .fromIterable(List.of("mafei", "alex", "rasan"))
                .transform(filerAndToUpper)
                .flatMap(this::splitString)
                .log();
    }

    public Flux<String> splitString(String name) {
        String[] splitName = name.split("");
        return Flux.fromArray(splitName);
    }
}
