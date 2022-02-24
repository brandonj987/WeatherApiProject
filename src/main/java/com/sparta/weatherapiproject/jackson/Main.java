package com.sparta.weatherapiproject.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

	@JsonProperty("temp")
	private double temp;

	@JsonProperty("temp_min")
	private double tempMin;

	@JsonProperty("grnd_level")
	private double grndLevel;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("pressure")
	private int pressure;

	@JsonProperty("sea_level")
	private double seaLevel;

	@JsonProperty("feels_like")
	private double feelsLike;

	@JsonProperty("temp_max")
	private double tempMax;

	@JsonProperty("visibility")
	private double visibility;

	public void setTemp(double temp){
		this.temp = temp;
	}

	public double getTemp(){
		return temp;
	}

	public void setTempMin(double tempMin){
		this.tempMin = tempMin;
	}

	public double getTempMin(){
		return tempMin;
	}

	public void setGrndLevel(double grndLevel){
		this.grndLevel = grndLevel;
	}

	public double getGrndLevel(){
		return grndLevel;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	public void setPressure(int pressure){
		this.pressure = pressure;
	}

	public int getPressure(){
		return pressure;
	}

	public void setSeaLevel(double seaLevel){
		this.seaLevel = seaLevel;
	}

	public double getSeaLevel(){
		return seaLevel;
	}

	public void setFeelsLike(double feelsLike){
		this.feelsLike = feelsLike;
	}

	public double getFeelsLike(){
		return feelsLike;
	}

	public void setTempMax(double tempMax){
		this.tempMax = tempMax;
	}

	public double getTempMax(){
		return tempMax;
	}

	public void setVisibility(double visibility){
		this.visibility = visibility;
	}

	public double getVisibility(){
		return visibility;
	}

	@Override
 	public String toString(){
		return 
			"Main{" + 
			"temp = '" + temp + '\'' + 
			",temp_min = '" + tempMin + '\'' + 
			",grnd_level = '" + grndLevel + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",sea_level = '" + seaLevel + '\'' + 
			",feels_like = '" + feelsLike + '\'' + 
			",temp_max = '" + tempMax + '\'' + 
			"}";
		}
}