package com.mafei.reactor.practice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class C14CombineMultipleReactiveStreamsTest {

    @Test
    void getNamesAndAges() {
        Flux<Object> namesAndAges = new C14CombineMultipleReactiveStreams().getNamesAndAges();
        StepVerifier.create(namesAndAges)
                .expectNext("Mafei", "Alex", "Asam", 27, 32, 45)
                .verifyComplete();
    }

    @Test
    void getNamesConcatWithAges() {
        Flux<String> namesAndAges = new C14CombineMultipleReactiveStreams().getNamesConcatWithAges();
        StepVerifier.create(namesAndAges)
                .expectNext("Mafei", "Alex", "Asam", "27", "32", "45")
                .verifyComplete();
    }
}