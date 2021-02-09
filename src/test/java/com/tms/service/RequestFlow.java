/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tms.service;

import static io.restassured.RestAssured.given;
/**
 *
 * @author thiago.meinel
 */
public class RequestFlow {

    public void okFlow(String corpo, String path) {
        given().contentType("text/html").body(corpo).
                when().post("http://localhost:8080" + path).
                then(). assertThat().statusCode(200);
    }
    
      public void createFlow(String corpo, String path) {
        given().contentType("text/html").body(corpo).
                when().post("http://localhost:8080" + path).
                then(). assertThat().statusCode(201);
    }

    public void badRequestFlow(String corpo, String path) {
        given().contentType("text/html").body(corpo).
                when().post("http://localhost:8080" + path).
                then().assertThat().statusCode(400);
    }
}
