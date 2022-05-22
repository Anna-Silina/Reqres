package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

  public class UserDelete {
        @Test
        public void deleteUserTest() {
            String body = given()
                    .when()
                    .delete("https://reqres.in/api/users/2")
                    .then()
                    .log().all()
                    .statusCode(204)
                    .extract().body().asString();
            UserDelete userDelete = new Gson().fromJson(body, UserDelete.class);
            int salaryTo = userDelete.getItems().get().getSalary().getTo();
            System.out.println(salaryTo);
            UserDelete userDeleteWithoutExpose = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(body, UserDelete.class);
            System.out.println(userDeleteWithoutExpose);
            System.out.println(userDelete);


        }
    }


