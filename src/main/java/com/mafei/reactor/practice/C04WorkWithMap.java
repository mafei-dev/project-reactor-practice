package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;

public class C04WorkWithMap {

    public static void main(String[] args) {
        new C04WorkWithMap().getNameWithUpper().subscribe(name ->
                System.out.println("name : " + name)
        );
    }

    public Flux<String> getNameWithUpper() {
        return Flux
                .fromIterable(List.of("mafei", "akil", "asam", "raman"))
                .map(String::toUpperCase);
    }
}
