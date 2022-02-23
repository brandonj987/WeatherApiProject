package com.sparta.weatherapiproject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys{

	@JsonProperty("sunrise")
	private int sunrise;

	@JsonProperty("sunset")
	private int sunset;

	public int getSunrise(){
		return sunrise;
	}

	public int getSunset(){
		return sunset;
	}
}