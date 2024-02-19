import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginTest {
    WebDriver driver;
    @DataProvider(name ="loginData" )
    public Object[][]getdata(){
        return new Object[][]{
                {"invalid","rahul123@gmail.com","rahul@123",},
                {"valid","harichandana1216@gmail.com","hari@1216"}
        };
    }
    @Test(dataProvider = "loginData")
    public void logincredentails(String type,String email,String password) {
        System.out.println(type+" "+email+" "+password);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://getmybooks.com/login");
        driver.findElement(By.id("signinEmail")).sendKeys(email);
        driver.findElement(By.id("signinPassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        if(type.contains("invalid")){
            WebElement errorparagraph= driver.findElement(By.xpath("//li[text()='Invalid username or password']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Invalid username or password']")));
            Assert.assertEquals("Invalid username or password",errorparagraph.getText());
        }else{
            wait.until(ExpectedConditions.urlToBe("https://getmybooks.com/"));
            String expectedurl= driver.getCurrentUrl();
            Assert.assertEquals("https://getmybooks.com/",expectedurl );
        }



    }


}
