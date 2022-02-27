package com.sparta.weatherapiproject.jacksonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain{

	@JsonProperty("3h")
	private Double jsonMember3h;

	@JsonProperty("1h")
	private Double jsonMember1h;

	public void setJsonMember3h(double jsonMember3h){
		this.jsonMember3h = jsonMember3h;
	}

	public Double getJsonMember3h(){
		return jsonMember3h;
	}

	public void setJsonMember1h(double jsonMember1h){
		this.jsonMember1h = jsonMember1h;
	}

	public Double getJsonMember1h(){
		return jsonMember1h;
	}

	@Override
 	public String toString(){
		return 
			"Rain{" + 
			"3h = '" + jsonMember3h + '\'' + 
			",1h = '" + jsonMember1h + '\'' + 
			"}";
		}
}