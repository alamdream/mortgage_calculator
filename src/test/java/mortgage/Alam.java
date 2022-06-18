package mortgage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alam {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.amazon.in/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Poco F1");
        driver.findElement(By.className("nav-input")).click();
        driver.navigate().to("https://www.facebook.com/rajshahiansilk.bd/photos/");
        Thread.sleep(4000);
        driver.quit();



    }
}
