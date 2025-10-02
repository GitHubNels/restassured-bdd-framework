package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.ConfigReader;

import static io.restassured.RestAssured.given;

public class ProductService {

    private void setBaseURI() {
        //  Read base URL dynamically from config file
        RestAssured.baseURI = ConfigReader.getBaseUrl();
        System.out.println("Base URI set to: " + RestAssured.baseURI);
    }

    //  GET all products
    public Response getAllProducts() {
        setBaseURI();
        return given()
                .log().all()
                .when()
                .get("/products")
                .then()
                .log().all()
                .extract().response();
    }

    //  GET single product by ID
    public Response getProductById(int id) {
        setBaseURI();
        return given()
                .log().all()
                .when()
                .get("/products/" + id)
                .then()
                .log().all()
                .extract().response();
    }

    //  POST product
    public Response createProduct(String jsonBody) {
        setBaseURI();
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/products")
                .then()
                .log().all()
                .extract().response();
    }

    //  Helper methods
    public double extractRate(Response response) {
        return response.jsonPath().getDouble("rating.rate");
    }

    public int extractId(Response response) {
        return response.jsonPath().getInt("id");
    }
}
