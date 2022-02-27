package com.sparta.weatherapiproject.jacksonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind{

	@JsonProperty("deg")
	private Integer deg;

	@JsonProperty("speed")
	private Double speed;

	@JsonProperty("gust")
	private Double gust;

	public void setDeg(int deg){
		this.deg = deg;
	}

	public Integer getDeg(){
		return deg;
	}

	public void setSpeed(double speed){
		this.speed = speed;
	}

	public Double getSpeed(){
		return speed;
	}

	public void setGust(double gust){
		this.gust = gust;
	}

	public Double getGust(){
		return gust;
	}

	@Override
 	public String toString(){
		return 
			"Wind{" + 
			"deg = '" + deg + '\'' + 
			",speed = '" + speed + '\'' + 
			",gust = '" + gust + '\'' + 
			"}";
		}
}