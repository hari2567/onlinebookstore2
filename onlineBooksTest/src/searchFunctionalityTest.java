import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class searchFunctionalityTest {
    WebDriver driver;

    @Test 
    public void searchTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://getmybooks.com/login");
        WebElement username = driver.findElement(By.id("signinEmail"));
        username.sendKeys("harichandana1216@gmail.com");
        WebElement password = driver.findElement(By.id("signinPassword"));
        password.sendKeys("hari@1216");

        WebElement button = driver.findElement(By.xpath("//button[text()='Sign In']"));
        button.click();

        WebElement searchbutton = driver.findElement(By.xpath("//button[starts-with(@class,'global')]"));
        searchbutton.click();

        WebElement searchname = driver.findElement(By.xpath("//input[starts-with(@class,'global')]"));
        searchname.sendKeys("Books");
        WebElement searchbutton2 = driver.findElement(By.xpath("//button[starts-with(@class,'global')]"));
        searchbutton2.click();
        List<WebElement> itemslist = driver.findElements(By.xpath("//ul[starts-with(@class,'products')]"));
        for (int i = 0; i < itemslist.size(); i++) {
            System.out.println(itemslist.get(i).getText());
        }
        driver.quit();


    }




}
