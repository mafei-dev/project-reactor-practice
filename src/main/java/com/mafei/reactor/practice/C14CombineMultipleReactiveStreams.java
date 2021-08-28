package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;

public class C14CombineMultipleReactiveStreams {

    //this functional function is reusable like a method.
    //it will return empty.
    public static Function<Flux<String>, Flux<String>> filerAndToUpper =
            name -> name.map(String::toUpperCase)
                    .filter(s -> s.length() > 6);


    public static void main(String[] args) throws InterruptedException {
        C14CombineMultipleReactiveStreams streams = new C14CombineMultipleReactiveStreams();
        streams.getNamesAndAges()
                .subscribe(value -> {
                    if (value instanceof String) {
                        System.out.println("Name = " + value);
                    } else if (value instanceof Integer) {
                        System.out.println("age = " + value);
                    }
                });
    }

    //get ages from the age server
    public Flux<Integer> getAges() {
        return Flux.fromIterable(List.of(27, 32, 45));
    }


    //get names from the name server
    public Flux<String> getNames() {
        return Flux.fromIterable(List.of("Mafei", "Alex", "Asam"));
    }

    public Flux<Object> getNamesAndAges() {
        return Flux.concat(this.getNames(), this.getAges());
    }

    //get ages from the age server
    public Flux<String> getAgesAsString() {
        return Flux.fromIterable(List.of("27", "32", "45"));
    }

    //get names from the name server
    public Flux<String> getNamesConcatWithAges() {
        return Flux.fromIterable(List.of("Mafei", "Alex", "Asam"))
                .concatWith(this.getAgesAsString());
    }


}
