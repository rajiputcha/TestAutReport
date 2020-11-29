package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Searchsteps {
      public WebDriver driver;
     public String searchTerm ="T-Shirts";

    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.next.co.uk/");
    }

    @When("^user enter product in search box$")
    public void user_enter_product_in_search_box()  {
        driver.findElement(By.xpath("//input[@id='sli_search_1']")).sendKeys("T-Shirt");

    }

    @When("^click on search icon$")
    public void click_on_search_icon()  {
        driver.findElement(By.xpath("//header/div[1]/section[1]/section[4]/form[1]/input[4]")).click();
    }

    @Then("^user should see products as search results$")
    public void user_should_see_products_as_search_results()  {
        String actualSearchResult = driver.findElement(By.xpath("//*[@id=\"ResultHeader\"]/div[1]/h1/div")).getText().trim();
        Assert.assertEquals(searchTerm, actualSearchResult);
        driver.quit();
    }

}
