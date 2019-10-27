package com.testapi;

import  io.restassured.RestAssured;
import  io.restassured.config.SSLConfig;
import  io.restassured.response.Response;
import  io.restassured.response.ResponseBody;
import  io.restassured.specification.RequestSpecification;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        RequestSpecification request = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()));

        Response response = request

                .when()
                .get("todos/6")

                .then()
                .statusCode(200)
                .extract().response();

        int responseCode = response.getStatusCode();
        System.out.println(responseCode);

        if (responseCode == 200)
        {
            System.out.println( "Bağlantı Kuruldu" );

            ResponseBody responseBody = response.getBody();
            System.out.println(responseBody.asString());

            System.out.println( "--------------------------------------------------------------------------" );
            String jsonResultTitle = response.jsonPath().getString("title");
            System.out.println(jsonResultTitle);
        }

        else{
            System.out.println( "Bağlantı Kurulamadı" );

        }


    }


}
