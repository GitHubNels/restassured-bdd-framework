package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import services.ProductService;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class GetProductSteps {

    private final ProductService service = new ProductService();
    private Response response;

    //  Get all products
    @Given("I hit the get product url")
    public void i_hit_the_get_product_url() {
        // Base URI is handled inside ProductService
    }

    @When("Check the get product ID response")
    public void check_the_get_product_id_response() {
        response = service.getAllProducts();
    }

    @And("verify the status code {int}")
    public void verify_the_status_code_code(int expectedStatus) {
        assertEquals(" Status mismatch!", expectedStatus, response.getStatusCode());
        System.out.println("GetProduct Status Code Verified: " + response.getStatusCode());
    }

    @Then("validate the schema")
    public void validate_the_schema() {
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/products-schema.json"));
        System.out.println(" Schema validation passed!");
    }

    //  Get specific product by ID
    @Given("I hit the get product url api endpoint {int}")
    public void i_hit_the_get_product_url_api_endpoint(int id) {
        response = service.getProductById(id);
    }

    @Then("I verify the rate of the {double} product")
    public void i_verify_the_rate_of_the_product(double expectedRate) {
        assertEquals(" Expected status 200", 200, response.getStatusCode());

        double actualRate = service.extractRate(response);
        assertEquals(" Rate mismatch!", expectedRate, actualRate, 0.01);

        System.out.println(" Verified rate: " + actualRate);
    }
}
