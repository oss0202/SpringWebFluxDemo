package com.oss.api.springwebfluxdemo.sample;

import java.util.Arrays;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxMonoTest {
	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("cropple", "bagel", "cookie");
		Flux<String> seq = Flux.fromIterable(stringList);
		seq.subscribe(i -> System.out.println(i));

		Flux<Integer> integerFlux = Flux.range(1, 3);
		integerFlux.subscribe(i -> System.out.println(i));

		System.out.println("-----------------------------------");
		Mono<String> stringMono = Mono.just("cropple");
		stringMono.subscribe(s -> System.out.println(s));
	}
}
