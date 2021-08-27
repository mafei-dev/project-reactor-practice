package com.mafei.reactor.practice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class C04WorkWithMapTest {

    @Test
    void getNameWithUpper() {
        C04WorkWithMap c04WorkWithMap = new C04WorkWithMap();
        Flux<String> nameWithUpper = c04WorkWithMap.getNameWithUpper();
        StepVerifier
                .create(nameWithUpper)
                .expectNext("MAFEI", "AKIL", "ASAM", "RAMAN")
                .verifyComplete();
    }
}