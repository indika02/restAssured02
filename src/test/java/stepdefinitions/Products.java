package stepdefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Products {

    public int StatusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    Map<String, Object> requestParams = new HashMap<>();

    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest = given();
        response=httpRequest.get("products");
    }

    @Then("^I receive the response code as (.*)$")
    public void i_receive_the_response_code_as_200(int responseCode) {
        ResponseCode=response.getStatusCode();
        assertEquals(ResponseCode,responseCode);
    }

    @Then("^I verify that the rate of the first product is (.*)$")
    public void i_verify_that_the_rate_of_first_product_is(String rate) {
        body=response.getBody();
        String responseBody=body.asString();
        JsonPath jsonpath=response.jsonPath();
        String s=jsonpath.getJsonObject("rating[0].rate").toString();
        assertEquals(rate,s);
    }

    @Given("I hit the url of post products api endpoint")
    public void i_hit_the_url_of_post_products_api_endpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        httpRequest=given();
    }

    @And("^I pass the request body of product details (.*?), (.*?), (.*?), (.*?), (.*?)$")
    public void i_pass_the_request_body_of_product_title(String title,float price,String description,String image,String category) {
        requestParams.put("title",title);
        requestParams.put("price",price);
        requestParams.put("description",description);
        requestParams.put("image",image);
        requestParams.put("category",category);
        httpRequest.body(requestParams.toString());
        Response response=httpRequest.post("products");
        ResponseBody body=response.getBody();

    }

    @Then("^I receive the response body with id as (.*)$")
    public void i_receive_the_response_body_with_id_as(String id) {
        httpRequest.body(requestParams.toString());
        Response response=httpRequest.post("products");
        ResponseBody body=response.getBody();
        JsonPath jsonpath=body.jsonPath();
        String s=jsonpath.getJsonObject("id").toString();
        assertEquals(id,s);
    }

    @Given("I hit the url of put products api endpoint")
    public void i_hit_the_url_of_put_products_api_endpoint() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        requestParams=new JSONObject();
    }

    @When("^I pass the url of products in the request with (.*)$")
    public void i_pass_the_url_of_products_in_the_request_with(int id,String title) {
        httpRequest=RestAssured.given();
        requestParams.put("title",title);
        httpRequest.body(requestParams.toString());
        response=httpRequest.put("products/{id}",id);
    }

    @Given("I hit the url of delete products api endpoint")
    public void i_hit_the_url_of_delete_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }

    @When("^I pass the url of delete products in the request with (.*)$")
    public void i_pass_the_url_of_delete_products_in_the_request_with(String id) {
        httpRequest = RestAssured.given();
        httpRequest.pathParam("id", id);
        httpRequest.delete("/products/{id}")
                .then()
                .statusCode(200);
    }

}
