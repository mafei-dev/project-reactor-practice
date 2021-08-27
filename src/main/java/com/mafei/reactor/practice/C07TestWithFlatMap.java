package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;

public class C07TestWithFlatMap {

    public static void main(String[] args) {

        Flux<String> nameWithUpper = new C07TestWithFlatMap().flatMapTest();
        nameWithUpper.subscribe(name ->
                System.out.println("name : " + name)
        );
    }

    public Flux<String> flatMapTest() {
        return Flux
                .fromIterable(List.of("mafei", "akil", "asam", "raman"))
                .map(String::toUpperCase)
                .filter(name -> name.length() > 4)
                //getting the filtered names and get as a flux of string array of flux
                .flatMap(this::splitString);
    }

    public Flux<String> splitString(String name) {
        String[] splitName = name.split("");
        return Flux.fromArray(splitName);
    }

}
