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

public class StepsPrueba {

    WebDriver driver;

    @Given("I am a customer with {string} and {string}")
    public void i_am_a_customer_with_username_and_password(String username,String password) throws Exception{
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/auth/login");
        driver.findElement(By.name("login-email")).sendKeys(username);
        driver.findElement(By.name("login-password")).sendKeys(password);
        driver.findElement(By.name("login-submit")).click();

    }
    @When("I select a category and product")
    public void i_select_a_category_and_product()throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Tortillas")));
        driver.findElement(By.name("Tortillas")).click();
    }
    @And("Set the quantity and click Add to Cart")
    public void set_the_quantity_and_click_add_to_cart() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Tortilla de pollo y verduras")));
        driver.findElement(By.name("quantity-Tortilla de pollo y verduras")).clear();
        driver.findElement(By.name("quantity-Tortilla de pollo y verduras")).sendKeys("5");
        driver.findElement(By.name("Tortilla de pollo y verduras")).click();
    }
    @And("I open cart")
    public void i_open_cart() throws Exception{
        driver.findElement(By.id("cart-icon")).click();
    }
    @Then("I am shown the total cost of my purchase")
    public void i_am_shown_the_total_cost_of_my_purchase() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-Tortilla de pollo y verduras")));
        String totalPrice = driver.findElement(By.id("cart-Tortilla de pollo y verduras")).getText();
        System.out.println(totalPrice);
        Assert.assertEquals(totalPrice,"S/60.00");
    }

}
