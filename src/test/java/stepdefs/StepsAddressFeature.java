package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepsAddressFeature {
    WebDriver driver;

    @Given("I am a user with {string} and {string}")
    public void i_am_a_user_with_username_and_password(String username,String password) throws Exception{
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/auth/login");
        driver.findElement(By.name("login-email")).sendKeys(username);
        driver.findElement(By.name("login-password")).sendKeys(password);
        driver.findElement(By.name("login-submit")).click();

    }
    @And("I select address menu")
    public void i_select_address_menu()throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("address-icon")));
        driver.findElement(By.id("address-icon")).click();
    }
    @When("I select the add button")
    public void i_select_the_add_button() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-button-address")));
        driver.findElement(By.id("add-button-address")).click();
    }

    @And("I fill {string} and fill {string} and {string}")
    public void i_fill_name_and_fill_lat_and_long(String name,String lat,String longitude) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("address-name")));
        driver.findElement(By.id("address-name")).sendKeys(name);

        driver.findElement(By.id("address-lat")).sendKeys(lat);
        driver.findElement(By.id("address-lng")).sendKeys(longitude);
        driver.findElement(By.id("retrieve-address")).click();
    }
    @And("I select confirm")
    public void i_select_confirm()throws Exception{
        driver.findElement(By.id("submit-address")).click();
    }
    @Then("I am shown my addresses and confirm that the address has been created")
    public void i_am_shown_my_addresses_and_confirm_that_the_address_has_been_created() throws Exception{

    }
}
