import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class addtoCart {
    @Test(priority = 1)
    public void addProducts(){
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
        driver.findElement(By.xpath("//a[@href='/the-poem-tree-introductory-book/p/f76f70ab5a']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[starts-with(@class,'suggested-item')]")).click();
        driver.findElement(By.xpath("//i[starts-with(@class,'flaticon-icon')]")).click();
        String expectedUrl="https://getmybooks.com/cart";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(actualurl,expectedUrl,"didnot match");
    }
    @Test(priority = 2)
    public void totalpricetest(){
        double price=140.0;
        int quantity=2;
        int discount=10;
        double expectedQuantity=120.0;
        double totalPrice=calculateTotalPrice(price,quantity,discount);
        Assert.assertEquals(expectedQuantity,totalPrice);
    }
    private double calculateTotalPrice(double price,int quantity,int discount){
        return price-(discount*quantity);
    }


    @Test(priority = 3)
    public void removingProducts() {
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
        driver.findElement(By.xpath("//a[@href='/the-poem-tree-introductory-book/p/f76f70ab5a']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//i[starts-with(@class,'flaticon-icon')]")).click();
        String expectedUrl2="https://getmybooks.com/cart";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl2));
        String actualurl2=driver.getCurrentUrl();
        Assert.assertEquals(actualurl2,expectedUrl2);
        driver.findElement(By.xpath("//a[starts-with(@class,'ls-decrement')]")).click();
        driver.findElement(By.xpath("//a[starts-with(@class,'ls-decrement')]")).click();
        WebElement name=driver.findElement(By.xpath("//p[starts-with(@class,'font-size-3')]"));
        System.out.println(name.getText());
        Assert.assertEquals("Your cart is empty",name.getText());


    }
}
