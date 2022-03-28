package com.oss.api.springwebfluxdemo.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SampleController {
	@GetMapping("/")
	Flux<String> sample(){
		return Flux.just("Hello", "World");
	}
}
