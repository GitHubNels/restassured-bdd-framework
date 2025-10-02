package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import services.ProductService;
import utility.JsonUtils;

import static org.junit.Assert.assertEquals;

public class PostProductSteps {

    private final ProductService service = new ProductService();
    private Response response;
    private String requestBody;

    // POST new product
    @When("I pass the request body {string} {int}")
    public void i_pass_the_request_body_filename(String fileName, int expectedStatus) {
        requestBody  = JsonUtils.readJson(fileName);
        
        response = service.createProduct(requestBody );

        assertEquals("Status mismatch for POST", expectedStatus, response.getStatusCode());
        System.out.println("POST executed with status: " + response.getStatusCode());
    }

    @Then("verify the createAPI status code {int}")
    public void verify_the_create_api_status_code(Integer expectedStatus) {
        assertEquals("Status mismatch!", (int) expectedStatus, response.getStatusCode());
        System.out.println("CreateProduct Status Code Verified: " + response.getStatusCode());
    }

    @Then("verify the response body matches the request body")
    public void verify_the_response_body_matches_the_request_body() {
        // Parse request JSON
        JsonPath requestJson = new JsonPath(requestBody);

        // Parse response JSON
        JsonPath responseJson = response.jsonPath();

        // Validate all fields (except id)
        assertEquals("Title mismatch!",
                requestJson.getString("title"),
                responseJson.getString("title"));

        //delta is junit declaration - Allows minor difference tolerance
        assertEquals("Price mismatch!",
                requestJson.getDouble("price"),
                responseJson.getDouble("price"),
                0.001);

        assertEquals("Description mismatch!",
                requestJson.getString("description"),
                responseJson.getString("description"));

        assertEquals("Image mismatch!",
                requestJson.getString("image"),
                responseJson.getString("image"));

        assertEquals("Category mismatch!",
                requestJson.getString("category"),
                responseJson.getString("category"));

        System.out.println(" Response body matches request body!");
    }
}
