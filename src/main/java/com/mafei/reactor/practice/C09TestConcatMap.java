package com.mafei.reactor.practice;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class C09TestConcatMap {

    public static void main(String[] args) throws InterruptedException {

        Flux<String> nameWithUpper = new C09TestConcatMap().concatMap();
        nameWithUpper.subscribe(name ->
                System.out.println("name : " + name)
        );

        //if we want to see the result, we have to sleep the main thread.
        Thread.sleep(100000);
    }

    public Flux<String> concatMap() {
        return Flux
                .fromIterable(List.of("mafei", "akil", "asam", "raman"))
                .map(String::toUpperCase)
                .filter(name -> name.length() > 4)
                //concat map await and collects the values until each flux completed one by one. 1-[M,A,F,I],2-[R,A,M,A,N].
                .concatMap(this::splitStringWithDelayed)
                .log();
    }

    public Flux<String> splitStringWithDelayed(String name) {
        System.out.println("C09TestConcatMap.splitStringWithDelayed name " + name);
        String[] splitName = name.split("");
//        int randomDelay = new Random().nextInt(1000);
//        sets a fix delay
        Duration duration; //for check order will be roted or not.
        if (name.startsWith("M")) {
            duration = Duration.ofSeconds(2);
        } else {
            duration = Duration.ofSeconds(1);
        }
        return Flux
                .fromArray(splitName)
                .delayElements(duration);

    }
}
