package com.oss.api.springwebfluxdemo.sample.vo;

import lombok.Data;

@Data
public class SampleVo {
	private String goodsNm;
	private boolean delivered = false;

	public static SampleVo createSampleResVo(String goodsNm) {
		SampleVo deliverSampleResVo = new SampleVo(goodsNm);
		deliverSampleResVo.setDelivered(true);
		return deliverSampleResVo;
	}

	private SampleVo(String goodsNm) {
		this.goodsNm = goodsNm;
	}
}
