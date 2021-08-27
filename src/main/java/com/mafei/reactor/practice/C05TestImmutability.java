package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;

public class C05TestImmutability {

    public static void main(String[] args) {

        //this will not be applied upper
        Flux<String> nameWithUpper1 = new C05TestImmutability().getNameWithUpper();
        nameWithUpper1
                .subscribe(name ->
                        System.out.println("name : " + name)
                );


        System.out.println("---------------------------");

        //this will be applied upper
        Flux<String> nameWithUpper = new C05TestImmutability().getNameWithUpper();
        nameWithUpper
                .map(String::toUpperCase)
                .subscribe(name ->
                        System.out.println("name : " + name)
                );
    }

    public Flux<String> getNameWithUpper() {
        Flux<String> stringFlux = Flux
                .fromIterable(List.of("mafei", "akil", "asam", "raman"));
        stringFlux.map(String::toUpperCase);
        return stringFlux;
    }
}
