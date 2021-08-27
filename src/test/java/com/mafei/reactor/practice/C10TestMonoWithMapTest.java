package com.mafei.reactor.practice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

class C10TestMonoWithMapTest {

    @Test
    void nameMonoMap() {
        Mono<List<String>> listMono = new C10TestMonoWithMap().nameMonoMap();
        StepVerifier
                .create(listMono)
                .expectNext(List.of("M", "A", "F", "E", "I"))
                .verifyComplete();

    }
}