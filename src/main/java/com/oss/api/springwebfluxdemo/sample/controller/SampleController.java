package com.oss.api.springwebfluxdemo.sample.controller;

import com.oss.api.springwebfluxdemo.sample.service.SampleService;
import com.oss.api.springwebfluxdemo.sample.vo.SampleVo;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
public class SampleController {
	private final SampleService sampleService;

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

	@GetMapping(value = "/getSample", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<SampleVo> getSampleList(){
		return sampleService.getSampleList();
	}
}
