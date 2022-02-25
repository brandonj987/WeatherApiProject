package com.sparta.weatherapiproject.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.java.eo.Do;

public class Snow{

	@JsonProperty("3h")
	private Double jsonMember3h;

	@JsonProperty("1h")
	private Double jsonMember1h;

	public void setJsonMember3h(Double jsonMember3h){
		this.jsonMember3h = jsonMember3h;
	}

	public Double getJsonMember3h(){
		return jsonMember3h;
	}

	public void setJsonMember1h(Double jsonMember1h){
		this.jsonMember1h = jsonMember1h;
	}

	public Double getJsonMember1h(){
		return jsonMember1h;
	}

	@Override
 	public String toString(){
		return 
			"Snow{" + 
			"3h = '" + jsonMember3h + '\'' + 
			",1h = '" + jsonMember1h + '\'' + 
			"}";
		}
}