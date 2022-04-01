package com.oss.api.springwebfluxdemo.sample.service;

import static com.oss.api.springwebfluxdemo.sample.vo.SampleVo.createSampleResVo;

import com.oss.api.springwebfluxdemo.sample.vo.SampleVo;
import java.nio.channels.Pipe;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SampleService {

	public Flux<SampleVo> getSampleList(){
		return Flux.<SampleVo> generate(sampleVoSynchronousSink -> sampleVoSynchronousSink.next(randomSample()))
				.delayElements(Duration.ofMillis(250));
	}

	private SampleVo randomSample(){
		return goodsList.get(picker.nextInt(goodsList.size()));
	}

	private List<SampleVo> goodsList = Arrays.asList(
		createSampleResVo("새우깡")
		,createSampleResVo("양파링")
		,createSampleResVo("새우깡")
	);

	private Random picker = new Random();
}
