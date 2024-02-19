import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class resetFunctionality {
    @Test
    public void restPassword(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://getmybooks.com/login");
        driver.findElement(By.id("signinEmail")).sendKeys("harichandana1216@gmail.com");
        driver.findElement(By.id("signinPassword")).sendKeys("hari@1213");
        driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
        driver.findElement(By.id("signinEmail3")).sendKeys("harichandana1216@gmail.com");
        driver.findElement(By.xpath("//button[text()='Recover Password']")).click();
        driver.findElement(By.id("signinEmail")).sendKeys("harichandana1216@gmail.com");
        driver.findElement(By.id("signinPassword")).sendKeys("hari@1216");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedurl3="https://getmybooks.com/";
        Assert.assertEquals("https://getmybooks.com/",expectedurl3);
        driver.quit();

    }
}
