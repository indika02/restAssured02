package methods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utils.configUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ProductsActions extends configUtils {

    public int StatusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    Map<String, Object> requestParams = new HashMap<>();
    public JsonPath jsonPath;

    public void gotourl(String preference){
        RestAssured.baseURI=configUtils.getBaseUri(preference);
        httpRequest=given();
        System.out.println(baseURI);
    }

    public void gorelevanturl(String uri){
        httpRequest = given();
        response=httpRequest.get(uri);
        body=response.getBody();
        response.getStatusCode();
    }

    public void confirmstatuscode(int code){
        ResponseCode=response.getStatusCode();
        assertEquals(ResponseCode,code);
    }

    public void verifyrate(String rate){
        body=response.getBody();
        JsonPath jsonpath=response.jsonPath();
        String s=jsonpath.getJsonObject("rating[0].rate").toString();
        assertEquals(rate,s);
        System.out.println(response.getStatusCode());
    }

    public void retrieveselectedCategory(String category){
        httpRequest=RestAssured.given();
        response=httpRequest.get("/products/category/"+category);
        body=response.getBody();
        response.getStatusCode();
        System.out.println(body.asString());
    }

    public void retrieveproductbyid(String id){
        httpRequest=RestAssured.given();
        response=httpRequest.get("/products/"+id);
        body=response.getBody();
        response.getStatusCode();
        System.out.println(body.asString()+" "+ response.getStatusCode());
    }

    public void postdata(String title,float price,String description,String image,String category){
        requestParams.put("title",title);
        requestParams.put("price",price);
        requestParams.put("description",description);
        requestParams.put("image",image);
        requestParams.put("category",category);
        httpRequest.body(requestParams.toString());
        response=httpRequest.post("products");
        body=response.getBody();
        response.getStatusCode();
        System.out.println(body.asString());
    }

    public void verifynewproductid(String id){
        httpRequest.body(requestParams.toString());
        response=httpRequest.post("products");
        body=response.getBody();
        jsonPath=body.jsonPath();
        String s=jsonPath.getJsonObject("id").toString();
        assertEquals(id,s);
    }

    public void updateproducttitle(String id,String title){
        httpRequest=RestAssured.given();
        requestParams.put("title",title);
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams);
        response=httpRequest.put("/products/"+id);
        body=response.getBody();
        StatusCode=response.getStatusCode();
        System.out.println("Response: " + body.asString());
        System.out.println("Status Code: " + StatusCode);
    }
    public void deleteproductbyid(String id){
        httpRequest = RestAssured.given();
        httpRequest.pathParam("id", id);
        response=httpRequest.delete("/products/{id}");
        StatusCode=response.getStatusCode();
    }
}
