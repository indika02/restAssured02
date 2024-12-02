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
import utils.configUtils;
import methods.ProductsActions;

import java.util.HashMap;
import java.util.Map;

public class Products extends ProductsActions{

    public int StatusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    Map<String, Object> requestParams = new HashMap<>();

    ProductsActions products=new ProductsActions();

    @Given("^Go to main url of products as (.*)$")
    public void i_hit_the_url_of_products_api_endpoint(String url) {
       products.gotourl(url);
    }

    @When("^Pass the url for (.*)$")
    public void i_pass_the_url_of_products_in_the_request(String url) {
       products.gorelevanturl(url);
        System.out.println(url);
    }

    @Then("^Confirm the response code as (.*)$")
    public void i_receive_the_response_code_as_200(int responseCode) {
       products.confirmstatuscode(responseCode);
    }

    @Then("^Verify the rate of the first product is (.*)$")
    public void i_verify_that_the_rate_of_first_product_is(String rate) {
       products.verifyrate(rate);
    }


    @And("^Pass the request body for product details as (.*?), (.*?), (.*?), (.*?), (.*?)$")
    public void i_pass_the_request_body_of_product_title(String title,float price,String description,String image,String category) {
        products.postdata(title,price,description,image,category);
    }

    @Then("^Verify the new product' id as (.*)$")
    public void verify_the_new_product_id_as(String id) {
       products.verifynewproductid(id);
    }


    @When("^Pass the data for updating with id as (.*?) and data as title (.*?)$")
    public void pass_the_data_for_products_with(String id,String title) {
       products.updateproducttitle(id,title);
    }

    @When("^Pass the id for delete product as (.*)$")
    public void pass_the_id_for_delete_product_as(String id) {
        products.deleteproductbyid(id);
    }

    @Then("^Retrieve the products of category as (.*)$")
    public void Retrieve_the_products_of_category_jewelery(String category){
        products.retrieveselectedCategory(category);
    }

    @Then("^Retrieve the product details of product id (.*)$")
    public void Retrieve_the_product_details_of_product_id(String id){
        products.retrieveproductbyid(id);
    }
}
