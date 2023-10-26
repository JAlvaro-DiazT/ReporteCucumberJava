package pom;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class StepDefinitionsSignIn {
    WebDriver driver;
    SignInPage signInPage;

    @Before
    public void setUp()  {
        driver = Hook.getDriver();
        signInPage = new SignInPage(driver);
    }
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {}
    @When("The user enters their username {string} and password {string}")
    public void the_user_enters_their_username_and_password(String user, String key) {
        signInPage.signIn(user, key);
    }
    @Then("The user should see the Logout button")
    public void the_user_should_see_the_logout_button() {
        assertTrue(signInPage.isDisplayed(signInPage.getRegisterGoOut()));
    }
    @And("The user should see the Menu button")
    public void the_user_should_see_the_menu_button() {
        assertTrue(signInPage.isDisplayed(signInPage.getRegisterMenu()));
    }
}
