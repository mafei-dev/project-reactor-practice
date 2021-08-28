package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;

public class C13DefaultValue {

    //this functional function is reusable like a method.
    //it will return empty.
    public static Function<Flux<String>, Flux<String>> filerAndToUpper =
            name -> name.map(String::toUpperCase)
                    .filter(s -> s.length() > 6);


    public static void main(String[] args) throws InterruptedException {

        Flux<String> flatMapMany = new C13DefaultValue().nameFluxTransformWithSwitchIf();

        flatMapMany.subscribe(name -> {
            System.out.println("name = " + name);
        });
    }

    public Flux<String> nameFluxTransform() {
        return Flux
                .fromIterable(List.of("mafei", "alex", "rasan"))
                .transform(filerAndToUpper)
                .flatMap(this::splitString)
                //we can add multiple defaults but the actual return value is that the 1st added value.
                .defaultIfEmpty("no_data1")
                .defaultIfEmpty("no_data2")
                .log();
    }

    public Flux<String> nameFluxTransformWithoutDefault() {
        return Flux
                .fromIterable(List.of("mafei", "alex", "rasan"))
                .transform(filerAndToUpper)
                .flatMap(this::splitString)
                .log();
    }

    public Flux<String> nameFluxTransformWithSwitchIf() {

        Function<Flux<String>, Flux<String>> filerAndToUpperAndFlat =
                name -> name
                        .map(String::toUpperCase)
                        .filter(s -> s.length() > 6)
                        .flatMap(this::splitString);

        Flux<String> noDataFlux = Flux.just("no_data").transform(filerAndToUpperAndFlat);

        return Flux
                .fromIterable(List.of("mafei", "alex", "rasan"))
                .transform(filerAndToUpperAndFlat)
                .switchIfEmpty(noDataFlux)
                .log();
    }

    public Flux<String> splitString(String name) {
        String[] splitName = name.split("");
        return Flux.fromArray(splitName);
    }
}
