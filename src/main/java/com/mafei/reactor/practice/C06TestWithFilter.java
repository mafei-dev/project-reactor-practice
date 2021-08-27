package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.util.List;

public class C06TestWithFilter {

    public static void main(String[] args) {

        Flux<String> nameWithUpper = new C06TestWithFilter().getNameWithUpper();
        nameWithUpper.subscribe(name ->
                System.out.println("name : " + name)
        );
    }

    public Flux<String> getNameWithUpper() {
        //filter the length of the name more than 4.
        return Flux
                .fromIterable(List.of("mafei", "akil", "asam", "raman"))
                .filter(name -> name.length() > 4);
    }
}
