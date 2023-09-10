package api.test;
import api.utilities.api.DataProviders;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DDTest {

 @Test(priority = 1 )
 public void BearerToken() {
  String bearerToken = "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO";
  given().headers("Authorization", "Bearer " + bearerToken)
          .when().get("https://pay2-admin.foodics.dev/login")
          .then().statusCode(200).log().all();
 }

 @Test(priority = 1 ,dataProvider ="Data",dataProviderClass = DataProviders.class)
 public void basicAuth(String useremail, String pwd) {
  // take Email & Password from Excel file (Userdata)
  given().auth().basic("Email", "Password")
          .when().get("https://pay2-admin.foodics.dev/login")
          .then().statusCode(200).log().all();
 }

 @Test(priority = 1 )
 public void allowedHTTP() {
  // the API only allowed to read only
  given().when().post("https://pay2.foodics.dev/404")
          .then().statusCode(405)
          .headers("allow","GET, HEAD")
          .log().all();
 }

}
