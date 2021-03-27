package com.pages;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.junit.Assert;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Pojo;

public class WebservicesAction {
	
	public Response response;
	public int statuscode;
	public JsonPath path;
	public HashMap<String,String> map ;
	public Pojo pj;
	public String endpint;
	
	public void actionResponse(String endpoint, String calltype ) {
		this.endpint = endpoint;
	switch(calltype){
	
	case "Get":
		
		response = given()
		.when()
			.get(endpoint)
		.then()
		.extract()
		.response();
		
		break;
		
	case "Post":
		headerMap();
		response = given()
		.headers(map)
		.contentType("application/json")
		.when()
			.post(endpoint)
		.then()
		.extract()
		.response();
		
		break;
	}	
	
	}
	
	 
	public void verifyResponseCode(int code) {
		 statuscode = response.statusCode();
		Assert.assertEquals(statuscode, code);

	}
	
	public void verifyJsonResponseArray( String field, String field_value,int index) {
		
		path = response.jsonPath();
		 String s =path.get("data["+index+"]."+field).toString();
		 
		 /*JSONParser jsonParser = new JSONParser();
		 JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) jsonParser.parse(response.asString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			//    int name = (int) jsonObject.get("per_page");  
		 
		System.out.println("name iss" + jsonObject.get("total_pages"));
		
		 JSONArray jsonArray = (JSONArray) jsonObject.get("data");
		 Iterator<String[]> iterator = jsonArray.iterator();
         while(iterator.hasNext()) {
            for(String s11:iterator.next()) {
            	System.out.println(s11);
            }
         }*/
		Assert.assertEquals(s, field_value);

	}
	
	public void verifyJsonResponse( String field, String field_value) {
		final ObjectMapper objectMapper = 
			    new ObjectMapper()
			        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);	
		
		System.out.println("endpoint is" + endpint);

			pj = RestAssured.given().when().get(endpint).as(Pojo.class);
			//pj = mp.readValue(response.toString(), Pojo.class);
			System.out.println("pj  is" + pj.toString());

			System.out.println("getPer_page isssssssssss" + pj.getPer_page());
		
	
		String per_page = pj.getPer_page();
		String total_pages = pj.getTotal_pages();
//		String id = pj.getData().;
		
		System.out.println("per_page isss" + per_page);
		System.out.println("total_pages isss" + total_pages);
		//System.out.println("id isss" + id);
		//path = response.jsonPath();
		 //String s =path.get(field).toString();
		//Assert.assertEquals(s, field_value);

	}
	
	public void headerMap() {
		map = new HashMap<String, String>();
		map.put("Postman-Token", "<calculated when request is sent>");
		//map.put("Content-Type", "application/json");
		map.put("Content-Length", "<calculated when request is sent>");
		map.put("Host", "<calculated when request is sent>");
		
	}
}
