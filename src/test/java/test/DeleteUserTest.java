package test;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class DeleteUserTest {
    private class UserDelete{

    }
    @Test
    public void deleteUserTest() {
        String body = given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204)
                .extract().body().asString();
        UserDelete userDelete = new Gson().fromJson(body,UserDelete.class);

    }
}
