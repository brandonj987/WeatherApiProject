package com.sparta.weatherapiproject.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain{

	@JsonProperty("3h")
	private int jsonMember3h;

	@JsonProperty("1h")
	private int jsonMember1h;

	public void setJsonMember3h(int jsonMember3h){
		this.jsonMember3h = jsonMember3h;
	}

	public int getJsonMember3h(){
		return jsonMember3h;
	}

	public void setJsonMember1h(int jsonMember1h){
		this.jsonMember1h = jsonMember1h;
	}

	public int getJsonMember1h(){
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