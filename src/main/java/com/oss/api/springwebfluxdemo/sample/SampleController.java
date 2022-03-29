package com.oss.api.springwebfluxdemo.sample;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SampleController {
	@GetMapping("/")
	Flux<String> sample(){
		return Flux.just("Hello", "World");
	}

	@GetMapping("/stream")
	Flux<Map<String, Integer>> stream(){
		Stream<Integer> integerStream = Stream.iterate(0, i -> i + 1); // 1씩 증가하는 무한 스트림
		return Flux.fromStream(integerStream.limit(10))
				.map(integer -> Collections.singletonMap("value", integer));
	}
}
