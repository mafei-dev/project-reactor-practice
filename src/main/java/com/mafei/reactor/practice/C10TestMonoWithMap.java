package com.mafei.reactor.practice;

import reactor.core.publisher.Mono;

import java.util.List;

public class C10TestMonoWithMap {

    public static void main(String[] args) throws InterruptedException {

        Mono<List<String>> listMono = new C10TestMonoWithMap().nameMonoMap();

        listMono.subscribe(name -> {
            System.out.println("name = " + name);
        });
    }

    public Mono<List<String>> nameMonoMap() {
        return Mono.just("mafei")
                .map(String::toUpperCase)
                .flatMap(this::splitString)
                .log();
    }

    public Mono<List<String>> splitString(String name) {
        String[] splitName = name.split("");
        List<String> stringList = List.of(splitName);
        return Mono.just(stringList);
    }
}
