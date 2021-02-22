package com.co.mercadolibre;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.co.mercadolibre.request.MutantRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SpringBootBootstrapLiveTest {  

    private static final String API_ROOT = "http://localhost:8080/mutant";

    @Test
    public void whenDNAIsHuman() {
    	MutantRequest request = new MutantRequest();
		request.setDna(new String[]{"ACCTATC","CTCACTT","ACGCTAT","ACCTACC","CAATTCC","CACCAAT","CAACAAT"});

        Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .post(API_ROOT);
        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatusCode());

    }
    
    @Test
    public void whenDNAIsMutant() {
    	MutantRequest request = new MutantRequest();
		request.setDna(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});

        Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .post(API_ROOT);
        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatusCode());

    }

}