package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class C08TestAsynchronousNature {

    public static void main(String[] args) {

        Flux<String> nameWithUpper = new C08TestAsynchronousNature().flatMapAsync();
        nameWithUpper.subscribe(name ->
                System.out.println("name : " + name)
        );
    }

    public Flux<String> flatMapAsync() {
        return Flux
                .fromIterable(List.of("mafei", "akil", "asam", "raman"))
                .map(String::toUpperCase)
                .filter(name -> name.length() > 4)
                //getting the filtered names and get as a flux of string array of flux
                .flatMap(this::splitStringWithDelayed);
    }

    public Flux<String> splitStringWithDelayed(String name) {
        String[] splitName = name.split("");
        int randomDelay = new Random().nextInt(1000);
        return Flux
                .fromArray(splitName)
                .delayElements(Duration.ofMillis(randomDelay));

    }
}
